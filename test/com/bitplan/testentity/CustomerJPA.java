package com.bitplan.testentity;

import javax.persistence.Entity;

@Entity
public class CustomerJPA implements Customer {

	long id;
	String name;
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long pid) {
		id=pid;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String pname) {
	  name=pname;	
	}

}
