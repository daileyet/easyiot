/**
 * 
 */
package com.openthinks.easyiot.links.service;

import java.util.List;

import com.openthinks.easyiot.links.core.msg.Message;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public interface PersistMessageService {

	void save(final List<Message> messages);
	
}
	