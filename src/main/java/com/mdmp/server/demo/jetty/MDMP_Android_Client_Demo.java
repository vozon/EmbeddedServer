package com.mdmp.server.demo.jetty;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.zip.Deflater;

import org.json.JSONException;
import org.json.JSONObject;


import com.mdmp.server.util.JsonUtils;

public class MDMP_Android_Client_Demo {
	private static final String SERVER_URL = "http://localhost:8090/mdmp/update";

	public static void sendEventsToServer(String appKey, SendData data) {
		HttpURLConnection connection = null;
		//Deflater deflater = null;
		DataOutputStream output = null;
		try {
			byte[] input = JsonUtils.convertFrom(data.getJson());
//			deflater = new Deflater();
//			deflater.setInput(input);
//			deflater.finish();
			int size = 0;
			byte[] byteData = new byte[0];
			byte[] buf = new byte[1024];
//			while (!deflater.finished()) {
//				int byteCount = deflater.deflate(buf);
//				byte[] temp = new byte[byteData.length + byteCount];
//				for (int i = 0; i < byteData.length; i++) {
//					temp[i] = byteData[i];
//				}
//				for (int i = 0; i < byteCount; i++) {
//					temp[(byteData.length + i)] = buf[i];
//				}
//				byteData = temp;
//				size += byteCount;
//			}

			URL url = new URL(new StringBuilder().append(SERVER_URL)
					.append("?appkey=" + appKey).toString());
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setReadTimeout(20000);
			connection.setConnectTimeout(20000);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type",
					"application/octet-stream");
			connection.connect();
			output = new DataOutputStream(connection.getOutputStream());
			output.write(input);
			output.flush();
			int httpCode = connection.getResponseCode();

			if (false) {
//				if (httpCode == 200) {
				StringBuffer sb = new StringBuffer();
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new InputStreamReader(
							connection.getInputStream()));
					String line = null;
					while ((line = reader.readLine()) != null)
						sb.append(line).append("\n");
				} catch (IOException e) {
//					Log.e("Mofang",
//							"[sendEventsToServer]IOException: get response");
					e.printStackTrace();
				} finally {
					if (reader != null) {
						try {
							reader.close();
						} catch (IOException e) {
//							Log.e("Mofang",
//									"[sendEventsToServer]IOException: reader.close()");
							e.printStackTrace();
						}
					}
				}
				String response = sb.toString();

//				if (response.indexOf("HTTPSQS_PUT_OK") > -1) {
//					StatEvent.signSentEvent(dbManager, data.getIdList());
//
//					StatEvent.clearAccessPath(dbManager);
//					StatEvent.clearHistoryEvents(dbManager,
//							getDateAndHour(time)[0]);
//				}
			}
		} catch (Exception e) {
			//Log.e("Mofang", "[sendEventsToServer]Exception");
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
//					Log.error("Mofang",
//							"[sendEventsToServer]IOException: output.close()");
					e.printStackTrace();
				}
			}
//			if (deflater != null) {
//				deflater.end();
//			}
			if (connection != null)
				connection.disconnect();
		}
	}
	
	public static void main(String[] args) throws JSONException {
		SendData data = new SendData();
		JSONObject json = new JSONObject();
		Date d = new Date();
		json.append("resumeTime", d.getTime());
		json.append("appKey", "test1_appkey");
		json.append("osType", "android");
		json.append("category", "avtivite01");
		json.append("action", "click");
		json.append("devId", "12345678");
		json.append("value", "2");
		data.setJson(json);
		sendEventsToServer("test1_appkey", data);
	}
}
