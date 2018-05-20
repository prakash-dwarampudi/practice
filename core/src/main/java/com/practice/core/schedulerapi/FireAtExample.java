package com.practice.core.schedulerapi;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class FireAtExample {
	
	private static final Logger LOG = LoggerFactory.getLogger(FireAtExample.class);
	
	@Reference
	Scheduler scheduler;
	
	@SuppressWarnings("deprecation")
	protected void activate(BundleContext ctx){
		
		Runnable jb = new Runnable() {
			@Override
			public void run() {
				LOG.info("message from FireAt: "+ System.currentTimeMillis());
			}
		};
		
		Date date = new Date();
		date.setTime(System.currentTimeMillis());
		
		try {
			scheduler.fireJobAt("Fire At",jb, new HashMap<String, Serializable>(), date);
		} catch (Exception e) {
			jb.run();
		}
	}

}
