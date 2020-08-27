/**
 * 
 */
package com.openthinks.easyiot.links.core.msg;

import com.openthinks.easyiot.links.core.parts.Whole;

import io.netty.channel.ChannelId;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public final class WholeChannelStringMessage extends WholeMessage<ChannelId, String> {

  public WholeChannelStringMessage(Whole<ChannelId, String> data) {
    super(data);
  }

  @Override
  public String getKeyAsString() {
    return payload.getKeyRef().asLongText();
  }

}
