package com.practice.core.felix.osgi.samplecomponent;

import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyOption;

@Component(name = "Profile Configuration", immediate = true, metatype = true)
public class ProfileConfiguration {

	@Property(name = "User Name", value = "", description = "Profile username", label = "Enter User Name")
	private static final String USER_NAME = "user.name";
	private String username;

	@Property(name = "Password", description = "Profile username", label = "Enter User Name", passwordValue = "")
	private static final String PASSWORD = "user.password";
	private String password;

	@Property(name = "Gender", description = "Gender", label = "Gender", options = {
			@PropertyOption(name = "Male", value = "male"),
			@PropertyOption(name = "Female", value = "female") }, value = "female")
	private static final String GENDER = "user.gender";
	private String gender;
	
	protected void activate(Map<String, Object> props){
		this.username = (String) props.get(USER_NAME);
		this.password  = (String) props.get(PASSWORD);
		this.gender = (String) props.get(GENDER);
	}

}
