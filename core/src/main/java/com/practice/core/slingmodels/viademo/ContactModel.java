package com.practice.core.slingmodels.viademo;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

@Model(adaptables = SlingHttpServletRequest.class)
public class ContactModel {
	
	@Inject
	private SlingHttpServletRequest request;

	private String username;

	@Inject
	@Via("resource")
	private String email;
	
	

	@PostConstruct
	protected void init(){
		this.username = request.getParameter("username");
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}