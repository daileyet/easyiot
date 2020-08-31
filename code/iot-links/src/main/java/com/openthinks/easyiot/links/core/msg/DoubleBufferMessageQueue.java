/**
 * 
 */
package com.openthinks.easyiot.links.core.msg;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.openthinks.libs.utilities.DateUtils;

/**
 * 
 * @author dailey.dai@openthinks.com
 *
 */
public class DoubleBufferMessageQueue implements MessageQueue {

  @SuppressWarnings("unchecked")
  private final Queue<Message>[] queues = new Queue[2];

  private final AtomicInteger writeIndex = new AtomicInteger(0);
  private final AtomicInteger readIndex = new AtomicInteger(1);

  private int swapThreshold = 60;
  private Duration maxReadInterval = Duration.ofMinutes(30);

  private final AtomicLong latestReadTime = new AtomicLong(DateUtils.currentTimeMillis());

  private final AtomicInteger writeQueueSize = new AtomicInteger(0);

  private volatile boolean isWaitForConsume = false;

  public DoubleBufferMessageQueue() {
    initialize();
  }


  @Override
  public boolean offer(Message message) {
    checkIfNeedSwap();
    Queue<Message> writeQueue = null;
    synchronized (this) {
      writeQueue = queues[writeIndex.get()];
    }
    if (writeQueue.offer(message)) {
      writeQueueSize.incrementAndGet();
      return true;
    }
    return false;
  }


  void checkIfNeedSwap() {
    if (!isWaitForConsume && writeQueueSize.get() >= swapThreshold) {
      swapQueue();
    } else if (!isWaitForConsume && writeQueueSize.get() > 0
        && DateUtils.between(latestReadTime.get(), DateUtils.currentTimeMillis()).abs()
            .compareTo(maxReadInterval) >= 0) {
      swapQueue();
    }
  }

  @Override
  public Optional<List<Message>> pollAll() {
    checkIfNeedSwap();
    Queue<Message> readQueue = null;
    synchronized (this) {
      readQueue = queues[readIndex.get()];
      isWaitForConsume = false;
    }
    List<Message> list = null;
    if (readQueue != null) {
      Message e = readQueue.poll();
      if (e != null)
        list = new ArrayList<>();
      while (e != null) {
        list.add(e);
        e = readQueue.poll();
      }
    }
    if (list != null) {
      latestReadTime.set(DateUtils.currentTimeMillis());
    }
    return Optional.ofNullable(list);
  }

  @Override
  public int size() {
    return writeQueueSize.get();
  }

  public void setMaxReadInterval(Duration maxReadInterval) {
    this.maxReadInterval = maxReadInterval;
  }

  public void setSwapThreshold(int swapThreshold) {
    this.swapThreshold = swapThreshold;
  }

  public Duration getMaxReadInterval() {
    return maxReadInterval;
  }

  public int getSwapThreshold() {
    return swapThreshold;
  }

  public int getReadIndex() {
    return readIndex.get();
  }

  public int getWriteIndex() {
    return writeIndex.get();
  }

  private void initialize() {
    for (int i = 0, len = queues.length; i < len; i++) {
      queues[i] = new ConcurrentLinkedQueue<>();
    }
  }

  private synchronized void swapQueue() {
    isWaitForConsume = true;
    int newWIndex = (writeIndex.get() + 1) % 2;
    int newRIndex = (newWIndex + 1) % 2;
    writeIndex.set(newWIndex);
    readIndex.set(newRIndex);
    writeQueueSize.set(queues[writeIndex.get()].size());
  }

}
