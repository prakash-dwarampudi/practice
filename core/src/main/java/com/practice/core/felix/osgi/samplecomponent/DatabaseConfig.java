package com.practice.core.felix.osgi.samplecomponent;

import java.util.Map;

public interface DatabaseConfig {
	
	String getDbName();
	
	String getDbUrl();
	
	String getDbUsername();
	
	String getDbPassword();
	
	void setProps(Map<String, Object> map);

}
