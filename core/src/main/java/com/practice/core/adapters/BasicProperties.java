package com.practice.core.adapters;

import java.util.List;

public class BasicProperties {
	
	private String name;
	private List<String> tags;
	private boolean isHiddenInNav;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public boolean isHiddenInNav() {
		return isHiddenInNav;
	}
	public void setHiddenInNav(boolean isHiddenInNav) {
		this.isHiddenInNav = isHiddenInNav;
	}
	
	

}
