/**
 * 
 */
package com.openthinks.easyiot.connector.schedule;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.openthinks.easyiot.core.mapper.BizRecordDataMapper;
import com.openthinks.easyiot.core.model.BizRecordData;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Component
public class SimulatorDataReceiver {

	private static final long RETRY_INTERVAL = 10000;

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	BizRecordDataMapper recordDataMapper;

	@Scheduled(initialDelay = 10000, fixedDelay = RETRY_INTERVAL)
	public void receivedData() {
//		insertData();
		insertData2();
	}

	final static int[] EVENTCOUNTS = { 100, 200, 300, 500, 800, 1300, 2100, 3400, 5500, 8900};
	
//	final static int[] EVENTCOUNTS = { 10};

	final static int DEVICEIDS_MAX_COUNT = 10000;

	final static Random random = new Random();

	void insertData2() {
		int index = (int) (Math.random() * EVENTCOUNTS.length);
		int count = EVENTCOUNTS[index];
		BizRecordData record = null;
		String val = null;
		List<BizRecordData> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			record = new BizRecordData();
			record.setTs(Date.from(Instant.now()));
			record.setDeviceId("DEVICE-" + ((int) (Math.random() * DEVICEIDS_MAX_COUNT) + 1));
			val = String.valueOf(i);
			record.setAttr1(val);
			record.setAttr2(val);
			record.setAttr3(val);
			record.setAttr4(val);
			record.setAttr5(val);
			record.setAttr6(val);
			record.setAttr7(val);
			record.setAttr8(val);
			record.setAttr9(val);
			record.setAttr10(val);
			record.setAttr11(val);
			record.setAttr12(val);
			record.setAttr13(val);
			record.setAttr14(val);
			record.setAttr15(val);
			list.add(record);
		}
		recordDataMapper.insertInBatch(list);
		list.clear();
	}
	
	
	void insertData() {
		int index = (int) (Math.random() * EVENTCOUNTS.length);
		int count = EVENTCOUNTS[index];
		BizRecordData record = null;
		String val = null;
		SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
		BizRecordDataMapper mapper = session.getMapper(BizRecordDataMapper.class);
		for (int i = 0; i < count; i++) {
			record = new BizRecordData();
			record.setTs(Date.from(Instant.now()));
			record.setDeviceId("DEVICE-" + ((int) (Math.random() * DEVICEIDS_MAX_COUNT) + 1));
			val = String.valueOf(i);
			record.setAttr1(val);
			record.setAttr2(val);
			record.setAttr3(val);
			record.setAttr4(val);
			record.setAttr5(val);
			record.setAttr6(val);
			record.setAttr7(val);
			record.setAttr8(val);
			record.setAttr9(val);
			record.setAttr10(val);
			record.setAttr11(val);
			record.setAttr12(val);
			record.setAttr13(val);
			record.setAttr14(val);
			record.setAttr15(val);
			mapper.insert(record);
		}
		session.commit();
	}

}
