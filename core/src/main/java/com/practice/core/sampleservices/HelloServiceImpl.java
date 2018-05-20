package com.practice.core.sampleservices;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service(value=HelloService.class, serviceFactory=true)
public class HelloServiceImpl implements HelloService {
	

	@Override
	public String getString() {
		return "Hello World!";
	}

}
