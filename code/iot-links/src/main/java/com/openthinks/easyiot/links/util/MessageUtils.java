/**
 * 
 */
package com.openthinks.easyiot.links.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.openthinks.easyiot.core.model.BizRecord;
import com.openthinks.easyiot.core.util.JSONUtils;
import com.openthinks.easyiot.links.core.msg.WholeMessage;
import com.openthinks.easyiot.links.core.parts.Whole;
import com.openthinks.libs.utilities.DateUtils;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public final class MessageUtils {

	public static final <K, V> BizRecord convertTo(WholeMessage<K, V> message) {
		return convertTo(message, null);
	}

	public static final <K, V> BizRecord convertTo(WholeMessage<K, V> message, String deviceId) {
		Whole<K, V> wholeData = message.payload();
		List<V> parts = wholeData.getValues();
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = parts.size(); i < j; i++) {
			V v = parts.get(i);
			if (v != null)
				sb.append(v.toString());
		}
		String content = sb.toString();
		if (deviceId == null) {
			deviceId = extractorDeviceId(content);
		}
		BizRecord record = new BizRecord.Builder().ts(Date.from(DateUtils.toInstant(wholeData.getFirstTime())))
				.data(content).devId(deviceId).build();
		return record;
	}

	public static String extractorDeviceId(String content) {
		String deviceId = null;
		Map<String, Object> map = JSONUtils.fromJSON(content);
		if (map != null) {
			Object val = map.get("deviceid");
			if (val != null)
				deviceId = val.toString();
		}
		return deviceId;
	}

}
