module com.secretpal.SecretPal {
	exports com.secretpal;
	exports com.secretpal.migrations;
	exports com.secretpal.model;
	exports com.secretpal.components.application;
	
	requires org.slf4j;
	requires org.wocommunity.webobjects.directtoweb;
	requires org.wocommunity.webobjects.dtwgeneration;
	requires org.wocommunity.webobjects.eocontrol;
	requires org.wocommunity.webobjects.foundation;
	requires org.wocommunity.webobjects.webobjects;
	requires org.wocommunity.wonder.directtoweb;
	requires org.wocommunity.wonder.erextensions;
	requires org.wocommunity.wonder.ajax;
	requires org.wocommunity.wonder.erattachment;
	requires org.wocommunity.wonder.erjavamail;
	
	
	
}