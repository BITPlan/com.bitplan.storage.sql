package com.bitplan.testentity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
//import javax.persistence.Transient;

import com.bitplan.storage.sql.JPABOImpl;

@Entity(name="Customer")
@Table (name="Customer")
public class CustomerJPAOld extends JPABOImpl<Customer> implements Customer {

	@Id
	Long id;
	String name;

	@Column(name="ORDER_ID")
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

  @OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
	private List<Order> orders;
  @Override
  public List<Order> getOrders() {
     List<Order> result=new ArrayList<Order>();
     for(Order o:orders) {
    	 result.add(o);
     }
     return result;
  }


	@Override
	public void setOrders(List<Order> porders) {
   orders=porders;		
	}

	@Override
	public Object getPrimaryKey() {
		return getId();
	}
}
