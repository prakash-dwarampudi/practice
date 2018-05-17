package com.practice.core.adapters;

import java.util.ArrayList;
import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.ValueMap;

import com.day.cq.wcm.api.Page;

@Component(metatype = true, immediate = true)
@Service
public class BasicPropertiesAdapter implements AdapterFactory {

	@Property(name = "adapters")
	protected static final String[] ADAPTER_CLASSES = { BasicProperties.class.getName() };

	@Property(name = "adaptables")
	protected static final String[] ADAPTABLE_CLASSES = { Page.class.getName() };

	@Override
	public <AdapterType> AdapterType getAdapter(Object adaptable, Class<AdapterType> type) {
		AdapterType adapterType = null;

		if (adaptable instanceof Page) {
			adapterType = adaptFromResource((Page) adaptable, type);
		}
		return adapterType;
	}

	private <AdapterType> AdapterType adaptFromResource(Page page, Class<AdapterType> type) {
		BasicProperties props = new BasicProperties();

		ValueMap vm = page.getProperties();
		props.setName(vm.get("jcr:title", String.class));
		String[] tags = vm.get("cq:tags", String[].class);
		List<String> tagList = new ArrayList<String>();
		for (String tag : tags) {
			tagList.add(tag);
		}
		props.setTags(tagList);
		props.setHiddenInNav(vm.get("hideInNav", Boolean.class));

		return (AdapterType) props;
	}

}
