/**   
 *
 * @author HYL   
 * @date 2017年12月28日 下午2:04:34
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.zfy.component.httpclient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zfy.component.httpclient.model.LocationPoint;

/**
 * 
 * @author HYL
 * @date 2017年12月28日 下午2:04:34
 * @version 0.1.0
 * @since 0.1.0
 */
public class Main {

	private static String AK = "c6vFV1DSjYWAUkGzzGGQHKvCC36L3FGb";

	private static String AMDIDV_FIND = "http://api.map.baidu.com/place/v2/search?query=盐田区信访局&region=深圳&city_limit=true&output=json&ak="
			+ AK;

	/**
	 * @param args
	 * @author HYL
	 * @date 2017年12月28日 下午2:04:34
	 */
	public static void main(String[] args) {

		JSONObject retObject = HttpClient.sendGetRequestToJson(AMDIDV_FIND);
		LocationPoint locationPoint = handleJsonObjectMap(retObject);
	}

	/**
	 * 处理百度地图返回的坐标</br>
	 * {"message":"ok","results":[{"uid":"b3b86fde98c0a711ae080f03","address":"景田东路9号","name":"深圳市财政委员会","location":{"lng":114.052337,"lat":22.557603},"detail":1,"street_id":"b3b86fde98c0a711ae080f03"},{"uid":"d7de1d1b50ff43b616b54bae","address":"深圳市福田区景田东路9号","name":"深圳市财政委员会-对外办事窗口","location":{"lng":114.052227,"lat":22.557037},"detail":1,"street_id":"d7de1d1b50ff43b616b54bae"},{"uid":"cc788fde8727af9388fc06cc","address":"景田东路70号福田区图书馆大厦首层东大门","name":"枫叶西餐厅","location":{"lng":114.052021,"lat":22.556567},"telephone":"0755-83055555","detail":1,"street_id":"cc788fde8727af9388fc06cc"}],"status":0}
	 * 
	 * @author HYL
	 * @date 2017年12月28日 下午3:28:59
	 */
	private static LocationPoint handleJsonObjectMap(JSONObject mapJson) {
		LocationPoint locationPoint = new LocationPoint();
		int status = Integer.parseInt(mapJson.get("status").toString());
		String message = mapJson.getString("message");
		JSONArray loacationArray = (JSONArray) mapJson.get("results");
		JSONObject detailObject;
		JSONObject location;

		if (loacationArray.size() <= 0) {
			return locationPoint;
		}

		detailObject = (JSONObject) loacationArray.get(0);
		location = (JSONObject) detailObject.get("location");
		locationPoint.setName(detailObject.get("name").toString());
		locationPoint.setAddress(detailObject.get("address").toString());
		locationPoint.setLng(location.get("lng").toString());
		locationPoint.setLat(location.get("lat").toString());
		
		return locationPoint;
	}
}
