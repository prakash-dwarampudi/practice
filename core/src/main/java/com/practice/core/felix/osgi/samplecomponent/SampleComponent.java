package com.practice.core.felix.osgi.samplecomponent;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(name = "Sample Component", immediate = true, metatype = true)
public class SampleComponent {

	private static final Logger LOG = LoggerFactory.getLogger(SampleComponent.class);

	@Property(name = "User Name", label = "Enter User Name", value = "Test Name", description="User Name ")
	private String name = "user.name";

	@Activate
	public void activate(Map<String, Object> properties, ComponentContext ctx) {
		LOG.info("Sample Componenet :"+ properties.get("user.name"));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
