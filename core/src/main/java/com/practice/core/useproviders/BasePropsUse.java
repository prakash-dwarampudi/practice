package com.practice.core.useproviders;

import com.adobe.cq.sightly.WCMUse;
import com.day.cq.wcm.api.Page;
import com.practice.core.adapters.BasicProperties;

public class BasePropsUse extends WCMUse {

	private BasicProperties props;

	public BasicProperties getProps() {
		return props;
	}

	public void setProps(BasicProperties props) {
		this.props = props;
	}

	@Override
	public void activate() throws Exception {

		Page page = this.getResourcePage();
		BasicProperties basicProps = page.adaptTo(BasicProperties.class);
	}

}
