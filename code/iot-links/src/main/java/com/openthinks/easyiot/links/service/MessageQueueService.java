/**
 * 
 */
package com.openthinks.easyiot.links.service;

import java.util.List;
import java.util.Optional;

import com.openthinks.easyiot.links.core.msg.Message;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public interface MessageQueueService {

  boolean offer(Message message);

  int size();

  Optional<List<Message>> pollAll();
}
