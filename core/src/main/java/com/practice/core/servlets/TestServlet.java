package com.practice.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import com.practice.core.sampleservices.HelloService;

@SuppressWarnings("serial")
@SlingServlet(paths="/bin/testone", methods="GET")
public class TestServlet extends SlingSafeMethodsServlet{
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceReference serviceRef = context.getServiceReference(HelloService.class.getName());
		HelloService helloService = (HelloService) context.getService(serviceRef);
		
		response.getWriter().write(helloService.getString());
		response.getWriter().flush();
	}
}
