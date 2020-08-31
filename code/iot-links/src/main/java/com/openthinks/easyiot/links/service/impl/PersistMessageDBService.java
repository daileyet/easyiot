/**
 * 
 */
package com.openthinks.easyiot.links.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.openthinks.easyiot.links.core.msg.Message;
import com.openthinks.easyiot.links.service.PersistMessageService;

/**
 * @author dailey
 *
 */
@Component
public class PersistMessageDBService implements PersistMessageService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistMessageDBService.class);

	@Override
	public void save(final List<Message> list) {
		//TODO save message to database
		LOGGER.debug("Save messages to database now");
	}

}
