/**
 * 
 */
package com.openthinks.easyiot.links.core.msg;

import java.util.List;
import java.util.Optional;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public interface MessageQueue {

  boolean offer(Message message);

  int size();

  Optional<List<Message>> pollAll();
}
