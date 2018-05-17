package com.practice.core.useproviders;

import java.util.ArrayList;
import java.util.List;

import com.adobe.cq.sightly.WCMUse;

public class CountriesUse extends WCMUse {
	
	private List<Country> countries;

	@Override
	public void activate() throws Exception {
		
		
		Country india = new Country("India", "Delhi");
		Country england = new Country("England", "London");
		
		countries = new ArrayList<Country>();
		countries.add(india);
		countries.add(england);
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	

}
