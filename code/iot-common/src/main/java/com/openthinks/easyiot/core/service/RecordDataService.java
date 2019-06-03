/**
 * 
 */
package com.openthinks.easyiot.core.service;

import java.util.List;

import com.openthinks.easyiot.core.model.BizRecordData;

/**
 * @author dailey.yet@outlook.com
 *
 */
public interface RecordDataService {

	List<BizRecordData> listAll();

	List<BizRecordData> listAllByDeviceId(String deviceId);

}
