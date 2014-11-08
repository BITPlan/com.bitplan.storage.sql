/**
 * Copyright (C) 2012 BITPlan GmbH
 *
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 */

package com.bitplan.storage.sql;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestEclipseLink.class, TestEclipseLinkSorting.class,TestSqlStorage.class})
/**
 * TestSuite
 * @author wf
 *
 * no content necessary - annotation has info
 */
public class TestSuite {
}
