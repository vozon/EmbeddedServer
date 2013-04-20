package com.mdmp.server.demo.servlets;

import java.io.DataInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
//import org.json.JSONException;
//import org.json.JSONObject;

import com.mdmp.server.demo.dao.DataDao;
import com.mdmp.server.demo.dao.DataDaoImpl;
import com.mdmp.server.demo.domain.DataBean;

/**
 * Servlet implementation class SelectServlet
 */
public class MDMPInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ObjectMapper mapper = new ObjectMapper();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MDMPInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletReqjuest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			//String appKey = (String) request.getAttribute("appKey");
			//System.out.println(appKey);
			ServletInputStream in = request.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			byte[] buf = new byte[1024];
			int bufSize = 0;
			StringBuffer sb = new StringBuffer();
			while((bufSize = dis.read(buf, 0, buf.length)) > 0){
				sb.append(new String(buf, 0 , bufSize));
			}
			String jsonStr = sb.toString();
			System.out.println(jsonStr);
//			JSONObject json = new JSONObject(sb.toString());
//			DataBean newBean = new DataBean();
//			newBean.setAction(json.getString("action"));
//			newBean.setAppKey(json.getString("appKey"));
//			newBean.setCategory(json.getString("category"));
//			newBean.setDevId(json.getString("devId"));
//			newBean.setOsType(json.getString("osType"));
//			newBean.setResumeTime(json.getString("resumeTime"));
//			newBean.setValue(json.getString("value"));
			DataBean newBean = mapper.readValue(jsonStr, DataBean.class);
			DataDao dao = new DataDaoImpl();
			dao.addDataBean(newBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}