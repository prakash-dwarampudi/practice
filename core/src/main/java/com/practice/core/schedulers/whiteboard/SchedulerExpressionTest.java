package com.practice.core.schedulers.whiteboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
//@Service(value = Runnable.class)
//@Property(name = "scheduler.expression", value = "0 * * * * ?")
public class SchedulerExpressionTest implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(SchedulerExpressionTest.class);

	@Override
	public void run() {
		LOG.info("Printed by Whiteboard expression based scheduler ");
	}

}
