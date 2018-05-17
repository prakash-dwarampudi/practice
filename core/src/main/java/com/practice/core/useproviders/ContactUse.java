package com.practice.core.useproviders;

import org.apache.sling.models.factory.ModelFactory;

import com.adobe.cq.sightly.WCMUse;
import com.practice.core.slingmodels.ContactModel;

public class ContactUse extends WCMUse {

	private ContactModel contactModel;

	@Override
	public void activate() throws Exception {

		ModelFactory mf = getSlingScriptHelper().getService(ModelFactory.class);
		contactModel = mf.createModel(getResource(), ContactModel.class);
	}

	public ContactModel getContactModel() {
		return contactModel;
	}

	public void setContactModel(ContactModel contactModel) {
		this.contactModel = contactModel;
	}

}
