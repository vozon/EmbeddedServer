package com.mdmp.server.demo.jetty;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.mdmp.server.util.JsonUtils;

public class MDMP_Android_Client_Demo {
	private static final String SERVER_URL = "http://localhost:8090/mdmp/update";

	public static void sendEventsToServer1(String appKey, SendData data) {
		URL url = null;
	    HttpURLConnection httpurlconnection = null;
	    try
	    {
	      url = new URL(SERVER_URL);
	      httpurlconnection = (HttpURLConnection) url.openConnection();
	      httpurlconnection.setDoInput(true);
	      httpurlconnection.setDoOutput(true);
	      httpurlconnection.setRequestMethod("POST");
	      //// POST CONTENT
			// String username="username=02000001";
			// httpurlconnection.getOutputStream().write(username.getBytes());
			// httpurlconnection.getOutputStream().flush();
			// httpurlconnection.getOutputStream().close();
	      DataOutputStream dos = new DataOutputStream(httpurlconnection.getOutputStream());
	      //String postContent = URLEncoder.encode("appKey", "UTF-8") + "=" + URLEncoder.encode(appKey, "UTF-8");
	      String postContent = JsonUtils.convertFrom(data.getJson());
	      dos.write(postContent.getBytes());
	      dos.flush();
	      dos.close();
	      //// POST CONTENT
	      
	      int code = httpurlconnection.getResponseCode();
	      System.out.println("code   " + code);

	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	      if(httpurlconnection!=null)
	        httpurlconnection.disconnect();
	    }
	}
	
	public static void sendEventsToServer(String appKey, SendData data) {
		HttpURLConnection connection = null;
		//Deflater deflater = null;
		DataOutputStream output = null;
		try {
			byte[] input = JsonUtils.convertFrom(data.getJson()).getBytes();
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
//			int httpCode = connection.getResponseCode();
//
//			if (false) {
////				if (httpCode == 200) {
//				StringBuffer sb = new StringBuffer();
//				BufferedReader reader = null;
//				try {
//					reader = new BufferedReader(new InputStreamReader(
//							connection.getInputStream()));
//					String line = null;
//					while ((line = reader.readLine()) != null)
//						sb.append(line).append("\n");
//				} catch (IOException e) {
////					Log.e("Mofang",
////							"[sendEventsToServer]IOException: get response");
//					e.printStackTrace();
//				} finally {
//					if (reader != null) {
//						try {
//							reader.close();
//						} catch (IOException e) {
////							Log.e("Mofang",
////									"[sendEventsToServer]IOException: reader.close()");
//							e.printStackTrace();
//						}
//					}
//				}
//				String response = sb.toString();
//
////				if (response.indexOf("HTTPSQS_PUT_OK") > -1) {
////					StatEvent.signSentEvent(dbManager, data.getIdList());
////
////					StatEvent.clearAccessPath(dbManager);
////					StatEvent.clearHistoryEvents(dbManager,
////							getDateAndHour(time)[0]);
////				}
//			}
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
		json.put("resumeTime", String.valueOf(d.getTime()));
		json.put("appKey", "test1_appkey");
		json.put("osType", "android");
		json.put("category", "avtivite01");
		json.put("action", "click");
		json.put("devId", "12345678");
		json.put("value", "2");
		data.setJson(json);
		sendEventsToServer1("test1_appkey", data);
	}
}
