package com.practice.core.felix.osgi.samplecomponent;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyOption;
import org.apache.sling.commons.osgi.PropertiesUtil;

@Component(name = "Profile Configuration", immediate = true, metatype = true)
public class ProfileConfiguration {

	@Property(value = "", description = "Profile username", label = "Enter User Name")
	private static final String USER_NAME = "user.name";
	private String username;

	@Property(description = "Profile username", label = "Enter User Name", passwordValue = "")
	private static final String PASSWORD = "user.password";
	private String password;

	@Property(description = "Gender", label = "Gender", options = {
			@PropertyOption(name = "male", value = "Male"),
			@PropertyOption(name = "female", value = "Female") }, value = "female")
	private static final String GENDER = "user.gender";
	private String gender;
	
	@Property(description="Is Admin User", label="Is Admin", boolValue=false)
	private static final String IS_ADMIN  = "is.admin";
	private Boolean isAdmin;
	
	@Activate
	protected void activate(Map<String, Object> props){
		this.username = PropertiesUtil.toString(props.get(USER_NAME), "");
		this.password  = PropertiesUtil.toString(props.get(PASSWORD), "");
		this.gender = PropertiesUtil.toString(props.get(GENDER), "");
		this.isAdmin = PropertiesUtil.toBoolean(IS_ADMIN, false);
	}

}
