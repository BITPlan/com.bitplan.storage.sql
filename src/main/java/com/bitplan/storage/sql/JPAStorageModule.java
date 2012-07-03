package com.bitplan.storage.sql;
/*
 * Copyright (C) 2011 BITPlan GmbH

 Pater-Delp-Str. 1
 D-47877 Willich-Schiefbahn

 http://www.bitplan.com

 $HeadURL$
 $LastChangedDate$
 $LastChangedRevision$
 $LastChangedBy$
 $Id$
 */

import com.bitplan.javax.persistence.Query;
import com.google.inject.AbstractModule;

/**
 * 
 * @author wf
 *
 */
public class JPAStorageModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Query.class).to(JPAQuery.class);
	}

}
