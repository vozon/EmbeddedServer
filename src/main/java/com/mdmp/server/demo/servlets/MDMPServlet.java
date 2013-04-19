package com.mdmp.server.demo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Authentication.User;

import com.mdmp.server.demo.dao.DataDao;
import com.mdmp.server.demo.dao.DataDaoImpl;
import com.mdmp.server.demo.domain.DataBean;

/**
 * Servlet implementation class SelectServlet
 */
public class MDMPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MDMPServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletReqjuest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=EUC-JP");
		StringBuffer stringBuf = new StringBuffer();

		try {
			request.
			DataDao dao = new DataDaoImpl();
			List<DataBean> list = dao.findAll();

			for (DataBean u : list) {
				stringBuf.append("<tr><td>" + u.getId() + "</td><td>"
						+ u.getName() + "</td></tr>");
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
		doGet(request, response);
	}
}