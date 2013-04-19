package com.mdmp.server.demo.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mdmp.server.demo.dao.DataDao;
import com.mdmp.server.demo.dao.DataDaoImpl;
import com.mdmp.server.demo.domain.DataBean;

/**
 * Servlet implementation class SelectServlet
 */
public class ConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletReqjuest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=EUC-JP");
		StringBuffer stringBuf = new StringBuffer();

		try {
			DataDao dao = new DataDaoImpl();
			Set<DataBean> list = dao.getAllDataBean();
			for (DataBean u : list) {
				stringBuf.append("<tr><td>" + u.getResumeTime() + "</td><td>"
						+ u.getAppKey() + "</td><td>" + u.getCategory()
						+ "</td></tr>");
			}
			request.setAttribute("table2", list);
		} finally {

		}

		request.setAttribute("table", stringBuf.toString());
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}