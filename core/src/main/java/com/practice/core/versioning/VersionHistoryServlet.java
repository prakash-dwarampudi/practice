package com.practice.core.versioning;

import java.io.IOException;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.version.Version;
import javax.jcr.version.VersionHistory;
import javax.jcr.version.VersionIterator;
import javax.jcr.version.VersionManager;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;


@SuppressWarnings("serial")
@SlingServlet(paths="/bin/versionhistory", methods="GET")
public class VersionHistoryServlet extends SlingSafeMethodsServlet{
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		try {
			String path = request.getParameter("path");
			Session session = request.getResourceResolver().adaptTo(Session.class);
			VersionManager vm = session.getWorkspace().getVersionManager();
			VersionHistory versionHistory = vm.getVersionHistory(path);
			VersionIterator vItr = versionHistory.getAllVersions();
			while(vItr.hasNext()){
				Version version = vItr.nextVersion();
				String name = version.getName();
				sb.append(name).append("\n");
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().write(sb.toString());
		response.getWriter().flush();
	}
}
