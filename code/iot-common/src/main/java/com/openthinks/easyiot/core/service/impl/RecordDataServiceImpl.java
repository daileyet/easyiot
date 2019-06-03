/**
 * 
 */
package com.openthinks.easyiot.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openthinks.easyiot.core.mapper.BizRecordDataMapper;
import com.openthinks.easyiot.core.model.BizRecordData;
import com.openthinks.easyiot.core.model.BizRecordDataExample;
import com.openthinks.easyiot.core.service.RecordDataService;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Service
public class RecordDataServiceImpl implements RecordDataService {

	@Autowired
	BizRecordDataMapper recordDataMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.easyiot.core.service.RecordDataService#listAll()
	 */
	@Override
	public List<BizRecordData> listAll() {
		BizRecordDataExample example = new BizRecordDataExample();
		return recordDataMapper.selectByExample(example);
	}

	@Override
	public List<BizRecordData> listAllByDeviceId(String deviceId) {
		BizRecordDataExample example = new BizRecordDataExample();
		example.createCriteria().andDeviceIdEqualTo(deviceId);
		return recordDataMapper.selectByExample(example);
	}

}
