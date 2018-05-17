package com.practice.core.slingmodels.source;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class)
public class ContactModel {

	@Inject
	@ValueMapValue
	private String email;
	
	@Inject
	SlingHttpServletRequest request;

	public String getEmail() {
		return email;
	}
	
	public void main(){
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
