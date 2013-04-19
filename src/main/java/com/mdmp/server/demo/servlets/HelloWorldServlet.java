package com.mdmp.server.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {   

	/**
	 * 
	 */
	private static final long serialVersionUID = 6257649239864795772L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.println("Hello, World, Johnny");
		out.close();
	}
}