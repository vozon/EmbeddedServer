package com.mdmp.server.demo.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mdmp.server.demo.dao.DataDao;
import com.mdmp.server.demo.dao.DataDaoImpl;
import com.mdmp.server.demo.domain.DataBean;

/**
 * Servlet implementation class SelectServlet
 */
public class MDMPListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MDMPListServlet() {
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
			Set<DataBean> beanSet = dao.getAllDataBean();
			stringBuf.append("<table>");
			stringBuf
					.append("<tr><td>Resume Tiem</td><td>" +
							"App Key</td><td>" +
							"OS Type</td><td>" +
							"Category</td><td>" +
							"Action</td><td>" +
							"Device Id</td><td>" +
							"Value</td></tr>");
			for (DataBean u : beanSet) {
				stringBuf.append("<tr><td>" 
						+ u.getResumeTime() + "</td><td>"
						+ u.getAppKey() + "</td><td>" 
						+ u.getOsType() + "</td><td>" 
						+ u.getCategory() + "</td><td>"
						+ u.getAction() + "</td><td>" 
						+ u.getDevId() + "</td><td>" 
						+ u.getValue() + "</td></tr>");
			}
			// request.setAttribute("table2", beanSet);
			stringBuf.append("</table>");
		} finally {
		}
		ServletOutputStream out = response.getOutputStream();
		out.print(stringBuf.toString());
		out.flush();
		response.flushBuffer();
		// request.setAttribute("table", stringBuf.toString());
		// request.getRequestDispatcher("output.jsp").forward(request,
		// response);
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