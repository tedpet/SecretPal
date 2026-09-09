package com.secretpal.components.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.appserver.WOContext;
import com.webobjects.directtoweb.D2WContext;
import com.webobjects.directtoweb.D2WPage;

public class PageWrapper extends SPComponent {
	
	private static final Logger LOG = LoggerFactory.getLogger(PageWrapper.class);

	public PageWrapper(WOContext context) {
		super(context);
		LOG.debug("PageWrapper");
	}

	public D2WContext d2wContext() {
		
		LOG.debug("D2WContext in the PageWrapper");
		if (context().page() instanceof D2WPage) {
			D2WPage d2wPage = (D2WPage) context().page();
			return d2wPage.d2wContext();
		}
		return null;
	}
	
	@Override
	protected boolean shouldCheckAccess() {
		return true;
	}
	
	@Override
	protected void checkAccess() throws SecurityException {
		
		LOG.debug("checkAccess() in the PageWrapper");

		if (context().page() instanceof D2WPage && (session().currentPerson() == null || !session().currentPerson().admin().booleanValue())) {
			throw new SecurityException("You must be an administrator to access this page.");
		}
	}
	

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}
}