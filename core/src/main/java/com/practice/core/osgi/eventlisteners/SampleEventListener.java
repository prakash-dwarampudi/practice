package com.practice.core.osgi.eventlisteners;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.UnsupportedRepositoryOperationException;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;
import javax.jcr.observation.ObservationManager;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;

@Component(immediate=true)
@Service
public class SampleEventListener implements EventListener{
	
	@Reference
	SlingRepository repository;
	
	private ObservationManager observationMgr;
	
	@Activate
	protected void activate(ComponentContext ctx){
		
		try {
			
			Session session = repository.loginAdministrative(null);
			
			observationMgr = session.getWorkspace().getObservationManager();
			String path = "/content/practice/en";
			String[] types = new String[]{"nt:unstructured"};
			observationMgr.addEventListener(this, Event.NODE_ADDED, path, true, null, types, true);
		}  catch (UnsupportedRepositoryOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onEvent(EventIterator et) {
		while(et.hasNext()){
			Event event = et.nextEvent();
			try {
				System.out.println("Event received under path: "+event.getPath());
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
