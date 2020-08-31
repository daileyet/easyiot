/**
 * 
 */
package com.openthinks.easyiot.links.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openthinks.easyiot.links.core.JSONPartPoolManagerPoxy;
import com.openthinks.easyiot.links.core.msg.WholeChannelStringMessage;
import com.openthinks.easyiot.links.core.msg.WholeMessage;
import com.openthinks.easyiot.links.core.parts.PartType;
import com.openthinks.easyiot.links.core.parts.Whole;
import com.openthinks.easyiot.links.service.MessageQueueService;
import com.openthinks.easyiot.links.service.PartDataService;

import io.netty.channel.ChannelId;

/**
 * @author dailey.dai@openthinks.com
 *
 */
@Component
public class PartDataServiceImpl implements PartDataService {
	private final static Logger LOGGER = LoggerFactory.getLogger(PartDataServiceImpl.class);
	private final JSONPartPoolManagerPoxy<ChannelId> channelDataPool = new JSONPartPoolManagerChannelPoxy();

	@Autowired
	MessageQueueService queueService;
	
	@Override
	public void put(ChannelId channelId, String content) {
		channelDataPool.put(channelId, content);
	}

	@Override
	public void remove(ChannelId channelId) {
		channelDataPool.remove(channelId);
	}

	/**
	 * Use {@link ChannelId} as part data reference key
	 * 
	 * @author dailey.dai@openthinks.com
	 *
	 */
	private final class JSONPartPoolManagerChannelPoxy extends JSONPartPoolManagerPoxy<ChannelId> {

		@Override
		protected void processWholeData(Whole<ChannelId, String> data, PartType type) {
			WholeMessage<ChannelId, String> message = new WholeChannelStringMessage(data);
			LOGGER.debug("Received JSON msg:{}",message);
			queueService.offer(message);
		}

	}
}
