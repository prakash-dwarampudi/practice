package com.practice.core.rest;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

@SlingServlet(methods="GET", paths="/bin/messagerest")
public class RestServlet extends SlingAllMethodsServlet {
	
	@Reference
	MessageService msgService;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
			Message msg = null;
		try {
			String msgId = request.getParameter("msgId");
			msg = msgService.getMessage(Integer.parseInt(msgId));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = msg != null ? msg.getMessage() : "";
		response.getWriter().write(str);
	}
}
