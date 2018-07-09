package com.practice.core.servlets;

import java.io.IOException;

import javax.jcr.Node;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

@SuppressWarnings("serial")
public class ReadJcrProperty extends SlingSafeMethodsServlet {
	
	
	
	@Override
	public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		String retVal = "";
		
		try {
			String path = request.getParameter("path");
			String propName = request.getParameter("key");
			
			ResourceResolver resResolver = request.getResourceResolver();
			Resource resource = resResolver.getResource(path);
			Node node = resource.adaptTo(Node.class);
			ValueMap valMap = resource.getValueMap();
			for(String key: valMap.keySet()){
				if(key.equals(propName)){
					String val = valMap.get(key, String.class);
					retVal = val;
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		response.getWriter().write(retVal);
	}
}
