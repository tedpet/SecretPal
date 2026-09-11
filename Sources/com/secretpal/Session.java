package com.secretpal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.secretpal.model.SPPerson;

import er.extensions.appserver.ERXSession;

public class Session extends ERXSession {
	private static final long serialVersionUID = 1L;

	private SPPerson _currentPerson;
	private SPNoticeList _errors;
	private SPNoticeList _notifications;
	private static final Logger LOG = LoggerFactory.getLogger(Session.class);

	public Session() {
		_errors = new SPNoticeList();
		_notifications = new SPNoticeList();
		setStoresIDsInCookies(true);
		setStoresIDsInURLs(false);
	}

	public SPNoticeList errors() {
		return _errors;
	}

	public SPNoticeList notifications() {
		return _notifications;
	}

	public void setCurrentPerson(SPPerson currentPerson) {
		_currentPerson = currentPerson;
	}

	public SPPerson currentPerson() {
		return _currentPerson;
	}
	
	@Override
	public String domainForIDCookies() {
		return "/";
	}
	
	public void logout() {
		setCurrentPerson(null);
		_errors.clearNotices();
		_notifications.clearNotices();
	}
}
