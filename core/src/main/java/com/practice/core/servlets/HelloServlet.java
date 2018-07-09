package com.practice.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

@SuppressWarnings("serial")
@SlingServlet(paths = "/bin/hello", methods = "GET")
public class HelloServlet extends SlingSafeMethodsServlet {

	public void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().write("Hello");
		response.getWriter().flush();

	};
}
