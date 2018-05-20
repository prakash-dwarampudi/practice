package com.practice.core.sampleservices;


import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

@SuppressWarnings("serial")
@SlingServlet(name="ServiceTest", methods="GET", paths="/bin/servicetest")
public class ServiceTest extends SlingSafeMethodsServlet{
	
	
	@Reference
	HelloService helloService;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		response.getWriter().write(helloService.toString());
	}
}
