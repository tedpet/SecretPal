package com.secretpal.components.group;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.secretpal.components.application.SPPage;
import com.secretpal.model.SPEvent;
import com.secretpal.model.SPGroup;
import com.secretpal.model.SPMembership;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;

public class SPHomePage extends SPPage {
	public SPMembership _membership;
	public SPEvent _event;
	private static final Logger LOG = LoggerFactory.getLogger(SPHomePage.class);

	public SPHomePage(WOContext context) {
		super(context);
	}

	public boolean canEdit() {
		return _membership.group().canEdit(session().currentPerson().localInstanceIn(_membership.editingContext()));
	}

	public String sectionClass() {
		return _membership.confirmed().booleanValue() ? "section" : "section pending";
	}

	public WOActionResults declineInvitation() {
		SPGroup group = _membership.group();
		SPMembership.declineInvitation(_membership);
		session().notifications().addNotice("Your invitation to '" + group.name() + "' has been declined.");
		return null;
	}

	public WOActionResults acceptInvitation() {
		EOEditingContext editingContext = ERXEC.newEditingContext();
		SPMembership localMembership = _membership.localInstanceIn(editingContext);
		localMembership.acceptInvitation();
		editingContext.saveChanges();
		return null;
	}
}