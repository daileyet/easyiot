/**
 * 
 */
package com.openthinks.easyiot.links.service.impl;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openthinks.easyiot.core.AppConfig;
import com.openthinks.easyiot.links.core.msg.DoubleBufferMessageQueue;
import com.openthinks.easyiot.links.core.msg.Message;
import com.openthinks.easyiot.links.service.MessageQueueService;


/**
 * @author dailey.dai@openthinks.com
 *
 */
@Component
public class MessageQueueServiceImpl implements MessageQueueService {
  private DoubleBufferMessageQueue messageQueue = new DoubleBufferMessageQueue();

  AppConfig appConfig;

  @Autowired
  public void setAppConfig(AppConfig appConfig) {
    this.appConfig = appConfig;
    messageQueue.setMaxReadInterval(Duration.ofMinutes(appConfig.getLinkQueueMaxReadInterval()));
    messageQueue.setSwapThreshold(appConfig.getLinkQueueSwapThreshold());
  }

  @PostConstruct
  void propertySet() {
    if (appConfig == null)
      return;
    messageQueue.setMaxReadInterval(Duration.ofMinutes(appConfig.getLinkQueueMaxReadInterval()));
    messageQueue.setSwapThreshold(appConfig.getLinkQueueSwapThreshold());
  }

  @Override
  public boolean offer(Message message) {
    return messageQueue.offer(message);
  }

  @Override
  public int size() {
    return messageQueue.size();
  }

  @Override
  public Optional<List<Message>> pollAll() {
    return messageQueue.pollAll();
  }

}
