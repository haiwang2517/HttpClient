/**   
 *
 * @author HYL   
 * @date 2017年12月28日 下午3:43:26
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.zfy.component.httpclient.model;

import java.io.Serializable;

/**   
 * 百度返回的坐标
 * @author HYL
 * @date 2017年12月28日 下午3:43:26
 * @version 0.1.0
 * @since 0.1.0  
 */
public class LocationPoint implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String address;
	
	private String lng;
	
	private String lat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}
	
	
}
