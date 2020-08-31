package com.openthinks.easyiot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.openthinks.easyiot.core.model.BizRecord;
import com.openthinks.easyiot.links.core.msg.Message;
import com.openthinks.easyiot.links.core.msg.WholeChannelStringMessage;
import com.openthinks.easyiot.links.service.PersistMessageService;
import com.openthinks.easyiot.links.util.MessageUtils;

public class MockPersistMessageService implements PersistMessageService {

	public final static Map<String, BizRecord> receivedMap = new ConcurrentHashMap<>();

	@Override
	public void save(List<Message> messages) {
		final List<BizRecord> records = new ArrayList<>();
		messages.forEach((msg) -> {
			BizRecord record = null;
			try {
				if (msg instanceof WholeChannelStringMessage) {
					record = MessageUtils.convertTo(((WholeChannelStringMessage) msg));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (record != null)
				records.add(record);
		});
		records.forEach((d) -> {
			System.out.println(d);
			receivedMap.put(d.getDevId(), d);
		});
	}

}
