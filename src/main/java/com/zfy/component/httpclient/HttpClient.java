/**   
 *
 * @author HYL   
 * @date 2017��12��28�� ����4:17:57
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.zfy.component.httpclient;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

/**   
 * HTTPClient�������
 * @author HYL
 * @date 2017��12��28�� ����4:17:57
 * @version 0.1.0
 * @since 0.1.0  
 */
public interface HttpClient {

	
	/**
	 * ���� Http����
	 * @param httpUrl
	 * @return JSONObject [FastJson]
	 * @author HYL   
	 * @date 2017��12��28�� ����4:21:10
	 */
	public static JSONObject sendGetRequestToJson(String httpUrl) {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(httpUrl);
		HttpResponse response;
		JSONObject ret = null;
		try {
			response = httpClient.execute(httpget);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
				System.out.println("[��ȡ����JSON]:["+strResult+"]");
				ret = (JSONObject) JSONObject.parse(strResult);
			}

		} catch (ParseException | IOException e) {
			e.printStackTrace();
			System.err.println("[��ȡ����ʧ��]:["+e.getMessage()+"]");
		}
		return ret;
	}
}
