package com.secretpal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.secretpal.components.person.SPResetPasswordEmail;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class SPNoticeList {
	private NSMutableArray<String> _notices;
	private static final Logger LOG = LoggerFactory.getLogger(SPNoticeList.class);

	public SPNoticeList() {
		_notices = new NSMutableArray<String>();
	}
	
	public synchronized boolean hasNotices() {
		return _notices.count() > 0;
	}

	public synchronized void addNotice(String error) {
		_notices.addObject(error);
	}

	public synchronized void clearNotices() {
		_notices.removeAllObjects();
	}

	public synchronized NSArray<String> notices() {
		return _notices.immutableClone();
	}
}
