package com.bluesunshine.douban4droid.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.bluesunshine.douban4droid.constants.DefaultConfigs;
import com.bluesunshine.douban4droid.model.app.AccessToken;
import com.bluesunshine.douban4droid.model.app.DoubanException;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.http.xml.XmlHttpContent;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.util.DateTime;

/**
 * 
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 * 
 * @author hao.wen <wenhao7704@gmail.com> Modified by hao.wen 2013-12-4
 *         将json-lib库更换成Android自带的Json解析库
 * 
 */
public class Converters {

	/**
	 * 
	 * 将用户JSON数据转换成AccessToken对象
	 * 
	 * @param responseStr
	 * @return
	 * @throws DoubanException
	 */
	public static AccessToken stringToAccessToken(String responseStr)
			throws DoubanException {
		if (responseStr == null) {
			throw ErrorHandler.cannotGetAccessToken();
		}

		JSONObject jObj = Converters.toJsonObj(responseStr);
		AccessToken token = new AccessToken();
		try {
			if (jObj.has("access_token")) {
				String accessToken = jObj.getString("access_token");
				token.setAccessToken(accessToken);
			} else {
				throw ErrorHandler.cannotGetAccessToken();
			}
			if (jObj.has("expires_in")) {
				int expiresIn = jObj.getInt("expires_in");
				token.setExpiresIn(expiresIn);
			} else {
				throw ErrorHandler.cannotGetAccessToken();
			}
			if (jObj.has("refresh_token")) {
				String refreshToken = jObj.getString("refresh_token");
				token.setRefreshToken(refreshToken);
			}
			if (jObj.has("douban_user_id")) {
				String doubanUserId = jObj.getString("douban_user_id");
				token.setDoubanUserId(doubanUserId);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return token;
	}

	public static Date convertStringToDateTimeInRFC3339(String dateStr) {
		DateTime dt = DateTime.parseRfc3339(dateStr);
		return new Date(dt.getValue());
	}

	public static String convertDateToStringInRFC3339(Date date) {
		DateTime dt = new DateTime(date.getTime(), 480);
		String wholeFormat = dt.toString();
		// Do a little hack here for converting the date into the proper string
		String result = wholeFormat.substring(0, wholeFormat.indexOf("."))
				+ wholeFormat.substring(wholeFormat.indexOf(".") + 4);
		return result;
	}

	/**
	 * 
	 * 将字符串转换成JSON对象
	 * 
	 * @author hao.wen <wenhao7704@gmail.com>
	 * 
	 * @param jsonStr
	 * @return
	 * @throws DoubanException
	 */
	public static JSONObject toJsonObj(String jsonStr) throws DoubanException {

		JSONObject result = null;
		try {
			result = new JSONObject(jsonStr);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			throw ErrorHandler.wrongJsonFormat(jsonStr);
		}
		return result;
	}

	public static <T> String parseDoubanObjToJSONStr(T obj) throws IOException {
		JsonHttpContent content = new JsonHttpContent(new JacksonFactory(), obj);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		content.writeTo(os);
		String result = new String(os.toByteArray());
		return result;
	}

	public static <T> String parseDoubanObjToXMLStr(T obj) throws IOException {
		XmlHttpContent content = new XmlHttpContent(
				DefaultConfigs.DOUBAN_XML_NAMESPACE, "entry", obj);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		content.writeTo(os);
		String result = new String(os.toByteArray());
		return result;
	}
}
