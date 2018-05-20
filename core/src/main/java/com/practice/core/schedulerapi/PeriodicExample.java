package com.practice.core.schedulerapi;

import java.io.Serializable;
import java.util.HashMap;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PeriodicExample {
	
	private static final Logger LOG = LoggerFactory.getLogger(PeriodicExample.class);
	
	@Reference
	Scheduler scheduler;
	
	@SuppressWarnings("deprecation")
	@Activate
	protected void activate(ComponentContext ctx){
		
		Runnable job = new Runnable() {
			
			@Override
			public void run() {
				LOG.info("printed from PeriodExample -> addPeriodJob");
			}
		};
		try {
		//	scheduler.addPeriodicJob("Periodic-Job", job, new HashMap<String, Serializable>(), 10, false);
		} catch (Exception e) {
			job.run();
		}
	}

}
