/**
 * 
 */
package com.openthinks.easyiot.links.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.openthinks.easyiot.links.service.MessageQueueService;
import com.openthinks.easyiot.links.service.PersistMessageService;

/**
 * Batch process received message in queue
 * @author dailey.dai@openthinks.com
 *
 */
@Component
public class ProcessMessageJob {
	private static final long RETRY_INTERVAL = 60000; // Millisecond
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessMessageJob.class);
	@Autowired
	MessageQueueService messageQueueService;

	@Autowired
	PersistMessageService persistMessageService;

	public void setPersistMessageService(PersistMessageService persistMessageService) {
		this.persistMessageService = persistMessageService;
	}

	@Scheduled(initialDelay = 10000, fixedDelay = RETRY_INTERVAL)
	public void checkReceivedMessageQueue() {
		LOGGER.debug("Check received messages in queue. Queue size:{}.", messageQueueService.size());
		messageQueueService.pollAll().ifPresent((list) -> {
			LOGGER.debug("Poll received messages in queue.Poll size:{}.", list.size());
			try {
				// store message
				persistMessageService.save(list);
			} catch (Exception e) {
				LOGGER.error("Failed to save messages:{} in queue list by reason:{}", list.size(), e);
			}
		});
	}
}
