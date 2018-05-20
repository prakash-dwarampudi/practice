package com.practice.core.felix.osgi.samplecomponent;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;

@Component(name = "DB Configuration Factory", immediate = true, metatype = true, configurationFactory=true)
@Service(value=DatabaseConfig.class)
public class DatabaseConfigFactory implements DatabaseConfig{

	@Property(name = "db.name", label = "Database Name", value = "reportsdb")
	private static final String DB_NAME = "db.name";
	private String dbName;

	@Property(name = "db.url", label = "Database Url", value = "")
	private static final String DB_URL = "db.url";
	private String dbUrl;

	@Property(name = "db.uname", label = "Database Username", value = "")
	private static final String DB_USERNAME = "db.uname";
	private String dbUsername;

	@Property(name = "db.password", label = "Database password", value = "")
	private static final String DB_PWD = "db.password";
	private String dbPassword;
	
	@Activate
	public void activate(Map<String, Object> props){
		setProps(props);
	}
	
	public void setProps(Map<String, Object> props){
		this.dbName = PropertiesUtil.toString(props.get(DB_NAME), "");
		this.dbUrl = PropertiesUtil.toString(props.get(DB_URL), "");
		this.dbUsername = PropertiesUtil.toString(props.get(DB_USERNAME), "");
		this.dbPassword = PropertiesUtil.toString(props.get(DB_PWD), "");
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

}
