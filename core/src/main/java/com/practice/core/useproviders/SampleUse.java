package com.practice.core.useproviders;

import java.util.LinkedHashMap;
import java.util.Map;

import com.adobe.cq.sightly.WCMUse;

public class SampleUse extends WCMUse {

	private String reverse;
	private Map<String, String> attribMap;

	public Map<String, String> getAttribMap() {
		return attribMap;
	}

	public void setAttribMap(Map<String, String> attribMap) {
		this.attribMap = attribMap;
	}

	@Override
	public void activate() throws Exception {
		String propName = this.get("propName", String.class);
		String value = getResource().getValueMap().get(propName, String.class);
		if (value != null && !value.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (int i = value.length() - 1; i >= 0; i--) {
				sb.append(value.charAt(i));
			}
			reverse = sb.toString();
		}
		attribMap = new LinkedHashMap<String, String>();
		attribMap.put("title", "My title");
		attribMap.put("class", "My Class");
		attribMap.put("id", "My Id");

	}

	public String getReverse() {
		return reverse;
	}

	public void setReverse(String reverse) {
		this.reverse = reverse;
	}

}
