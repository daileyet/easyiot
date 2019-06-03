package com.openthinks.easyiot.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openthinks.easyiot.core.model.BizRecordData;
import com.openthinks.easyiot.core.service.RecordDataService;
import com.openthinks.libs.utilities.json.JSON;
import com.openthinks.libs.utilities.json.JSONArray;
import com.openthinks.libs.utilities.json.JSONConverters;
import com.openthinks.libs.utilities.json.JSONObject;

@RestController
@RequestMapping("data")
public class RecordDataAPI {

	@Autowired
	RecordDataService dataService;
	
	@GetMapping("/list/all")
    public Object listAll() {
		JSONObject root = JSON.object();
		JSONObject data = root.createEmbedJSONObj("data");
		JSONArray array = data.createEmbedArray("items");
        List<BizRecordData> recordList = dataService.listAll();
        recordList.forEach(u->{
        	array.add(JSONConverters.perparedAndGet(u));
        });
        return root;
    }
	
	@GetMapping("/list/{device_id}")
    public Object listByDevice(@PathVariable("device_id") String deviceId) {
		JSONObject root = JSON.object();
		JSONObject data = root.createEmbedJSONObj("data");
		JSONArray array = data.createEmbedArray("items");
        List<BizRecordData> recordList = dataService.listAllByDeviceId(deviceId);
        recordList.forEach(u->{
        	array.add(JSONConverters.perparedAndGet(u));
        });
        return root;
    }
	
}
