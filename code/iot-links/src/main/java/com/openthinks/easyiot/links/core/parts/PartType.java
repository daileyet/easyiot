/**
 * 
 */
package com.openthinks.easyiot.links.core.parts;

import com.openthinks.easyiot.links.servers.ServerStarter;

/**
 * Partly received data type in {@link ServerStarter}
 * 
 * @author dailey.dai@openthinks.com
 *
 */
public enum PartType {
  /**
   * first part, message head
   */
  FIRST,
  /**
   * middle part, message body
   */
  MIDDLE,
  /**
   * last part, message tail
   */
  LAST,
  /**
   * complete one, whole message
   */
  WHOLE, NONE;
}
