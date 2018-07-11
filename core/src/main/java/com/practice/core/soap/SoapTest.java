package com.practice.core.soap;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import com.sample.Employee;
import com.sample.EmployeeService;
import com.sample.EmployeeService_Service;

@SuppressWarnings("serial")
@SlingServlet(methods = "GET", paths = "/bin/soaptest")
public class SoapTest extends SlingAllMethodsServlet {

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		String resp = "No resp";
		try {
			String name = request.getParameter("empname");
			EmployeeService_Service empServiceService = new EmployeeService_Service();
			EmployeeService empService = empServiceService.getEmployeeServiceImplPort();

			Employee emp = empService.getEmployee(name);

			StringBuilder sb = new StringBuilder();
			sb.append(emp.getName()).append(',').append(emp.getDept()).append(',').append(emp.getAge());
			resp = sb.toString();
		} catch (Exception e) {

		}

		response.getWriter().write(resp);
	}

}
