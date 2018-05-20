package com.practice.core.felix.osgi.samplecomponent;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.cm.ConfigurationAdmin;

@SuppressWarnings("serial")
@SlingServlet(name="Test Servlet", methods="GET", paths="/bin/dbcon")
public class TestServlet extends SlingSafeMethodsServlet{
	
	
	@Reference
	ConfigurationAdmin configAdmin;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		DatabaseConfig dbConn = null;
		try{
			String dbName = request.getParameter("dbname");
			dbConn = DatabaseConfigCache.getConfig(dbName);
		}
		catch(Exception e){
			//TODO
		}
		
		response.setContentType("text/html");
		response.getWriter().write(dbConn.getDbUrl());
	}
}
