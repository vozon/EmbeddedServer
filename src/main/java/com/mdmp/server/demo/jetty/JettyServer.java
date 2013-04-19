package com.mdmp.server.demo.jetty;

import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

	private static final int DEFAULT_SERVER_PORT = 8080;

	public static void main(String[] args) throws Exception {

		int serverPort = DEFAULT_SERVER_PORT;
		if(args.length == 1) {
			serverPort = Integer.parseInt(args[0]);
		}

		System.out.println("Running Jetty server on port " + serverPort);

		Server server = new Server(serverPort);
		WebAppContext root = new WebAppContext();

		final URL webappUrl = JettyServer.class.getClassLoader().getResource("webapp");
		final String webappUrlStr = webappUrl.toExternalForm();

		root.setContextPath("/");
		root.setDescriptor(webappUrlStr + "WEB-INF/web.xml");
		root.setResourceBase(webappUrlStr);

		root.setParentLoaderPriority(true);

		server.setHandler(root);

		server.start();
		server.join();
	}
}