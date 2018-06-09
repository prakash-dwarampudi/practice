package com.practice.core.workflows;

import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.HistoryItem;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component
@Service
@Properties({ @Property(name = Constants.SERVICE_DESCRIPTION, value = "Sample Workflow Process"),
		@Property(name = Constants.SERVICE_VENDOR, value = "Adobe"),
		@Property(name = "process.label", value = "Sample Workflow Process") })
public class SampleWorkflow implements WorkflowProcess {

	private static final Logger LOG = LoggerFactory.getLogger(SampleWorkflow.class);

	@Override
	public void execute(WorkItem workItem, WorkflowSession wfSession, MetaDataMap metaDataMap)
			throws WorkflowException {
		List<HistoryItem> list = wfSession.getHistory(workItem.getWorkflow());
		for(HistoryItem histItem : list){
			MetaDataMap map = histItem.getWorkItem().getMetaDataMap();
			for(java.util.Map.Entry<String, Object> entry :map.entrySet()){
				String key = entry.getKey();
				String value = entry.getValue().toString();
				LOG.error(key+" == "+ value);
			}
		}
		LOG.error("Message from Sample Workflow Process");
	}

}
