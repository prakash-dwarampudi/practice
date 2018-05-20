package com.practice.core.schedulerapi;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class ExpressionExample {

	private static final Logger LOG = LoggerFactory.getLogger(ExpressionExample.class);

	@Reference
	Scheduler scheduler;

	@SuppressWarnings("deprecation")
	@Activate
	protected void activate(ComponentContext ctx) {

		final Runnable job = new Runnable() {

			@Override
			public void run() {
				LOG.info("Printed from scheduler api addJOB() ");
			}
		};
		
		Map<String, Serializable> map = new HashMap<String, Serializable>();
		
		String schedulerExpr = "0 * * * * ?";

		try {
		//	scheduler.addJob("Expression Example", job, map, schedulerExpr, false);
		} catch (Exception e) {
			job.run();
		}

	}
}
