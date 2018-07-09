package com.practice.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.sling.SlingFilter;
import org.apache.felix.scr.annotations.sling.SlingFilterScope;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;

@SlingFilter(metatype = true, generateComponent = true, generateService = true, scope = SlingFilterScope.REQUEST, order = 1)
@Properties({@Property(name="pattern", value="/content/campaigns/geometrixx-outdoors")})
public class TestFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (!(request instanceof SlingHttpServletRequest) || !(response instanceof SlingHttpServletResponse)) {
			chain.doFilter(request, response);
		} else {
			SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) request;
			SlingHttpServletResponse slingResponse = (SlingHttpServletResponse) response;
			Resource resource = slingRequest.getResource();

			if (resource.getPath().startsWith("/content/campaigns")) {
				slingResponse.sendRedirect("/content/geometrixx-gov/en.html");
			}
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
