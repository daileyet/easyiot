/**
 * 
 */
package com.openthinks.easyiot.links.service;

import io.netty.channel.ChannelId;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public interface PartDataService {

  void put(ChannelId channelId, String content);

  void remove(ChannelId channelId);

}
