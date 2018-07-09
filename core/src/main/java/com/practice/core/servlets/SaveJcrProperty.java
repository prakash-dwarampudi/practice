package com.practice.core.servlets;

import java.io.IOException;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.ServletException;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

@SuppressWarnings("serial")
public class SaveJcrProperty extends SlingSafeMethodsServlet {
	
	
	
	@Override
	public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		
		try {
			String path = request.getParameter("path");
			String propName = request.getParameter("key");
			String value = request.getParameter("value");
			
			ResourceResolver resResolver = request.getResourceResolver();
			Session sess = resResolver.adaptTo(Session.class);
			Node node = JcrUtils.getOrCreateByPath(path, "nt:unstructured", sess);
			node.setProperty(propName, value);
			sess.save();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
