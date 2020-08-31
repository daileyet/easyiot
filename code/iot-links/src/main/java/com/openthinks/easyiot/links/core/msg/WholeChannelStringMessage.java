/**
 * 
 */
package com.openthinks.easyiot.links.core.msg;

import java.util.Iterator;
import java.util.Optional;

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
  
  public Optional<String> getWholeContent() {
	  if(payload.getValues().isEmpty())
		  return Optional.empty();
	  StringBuffer sb = new StringBuffer();
	  Iterator<String> iter=payload.getValues().iterator();
	  while(iter.hasNext()) {
		  sb.append(iter.next());
	  }
	  return Optional.of(sb.toString());
  }

}
