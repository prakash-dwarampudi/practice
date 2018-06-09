package com.practice.core.workflows;

import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.HistoryItem;
import com.adobe.granite.workflow.exec.ParticipantStepChooser;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component
@Service
@Properties({ @Property(name = Constants.SERVICE_DESCRIPTION, value = "Sample Dynamic Participant"),
	@Property(name = Constants.SERVICE_VENDOR, value = "Adobe"),
	@Property(name = "process.label", value = "Sample Dynamic Participant") })
public class DynamicParticipant implements ParticipantStepChooser{

	@Override
	public String getParticipant(WorkItem workItem, WorkflowSession wfSession, MetaDataMap map) throws WorkflowException {
		List<HistoryItem> list = wfSession.getHistory(workItem.getWorkflow());
		for(HistoryItem histItem : list){
			//
		}
		String participant = "admin";
		WorkflowData wfData  = workItem.getWorkflowData();
		if("JCR_PATH".equalsIgnoreCase(wfData.getPayloadType())){
			String path = wfData.getPayload().toString();
			if(path.startsWith("/content/practice")){
				participant = "practice-publisher";
			}
		}
		
		return participant;
	}

}
