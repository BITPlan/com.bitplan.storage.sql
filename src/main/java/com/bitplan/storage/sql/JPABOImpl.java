package com.bitplan.storage.sql;

import javax.xml.bind.annotation.XmlTransient;

import org.simpleframework.xml.Transient;

import com.bitplan.restinterface.BO;
import com.bitplan.restinterface.BOManager;

/**
 * XML based Implementation for a Business object of Type BO_T 
 * @author wf
 * @param <BO_T>
 */
public abstract class JPABOImpl<BO_T> implements BO<BO_T> {

	@Transient
	@XmlTransient
	BOManager<BO_T> boManager;
	
	protected BO_T mBO;
	
	@Override
	public BOManager<BO_T> getBOManager() {
		return boManager;
	}

	@Override
	public void setBOManager(BOManager<BO_T> pBOManager) {
		boManager=pBOManager;
	}
	
	@Override
	public  BO_T getBO() {
		return mBO;
	}
	
}
