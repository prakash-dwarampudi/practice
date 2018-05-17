package com.practice.core.slingmodels.interfaceexample;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class)
public interface ContactModel {
	
	@Inject
	String getEmail();
	
	@Inject
	String getPhone();

}
