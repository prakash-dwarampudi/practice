package com.practice.core.schedulers.whiteboard;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Service(value = Runnable.class)
//@Property(name = "scheduler.period",  longValue=10)
public class SchedulerPeriodExample implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(SchedulerPeriodExample.class);

	@Override
	public void run() {
		LOG.info("Printed by Whiteboard periodic based scheduler ");
	}

}
