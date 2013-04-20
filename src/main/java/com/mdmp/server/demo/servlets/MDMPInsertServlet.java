package com.mdmp.server.demo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mdmp.server.demo.dao.DataDao;
import com.mdmp.server.demo.dao.DataDaoImpl;
import com.mdmp.server.demo.domain.DataBean;

/**
 * Servlet implementation class SelectServlet
 */
public class MDMPInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			String appKey = (String) request.getAttribute("appKey");
			ServletInputStream in = request.getInputStream();
//			in.
			DataDao dao = new DataDaoImpl();
			
			//dao.addDataBean(newBean);
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