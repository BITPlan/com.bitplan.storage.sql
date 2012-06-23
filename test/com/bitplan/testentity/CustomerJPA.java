package com.bitplan.testentity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
//import javax.persistence.Transient;

@Entity(name="Customer")
@Table (name="Customer")
public class CustomerJPA implements Customer {

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
	private Collection<OrderJPA> orders;
  @Override
  public Collection<Order> getOrders() {
      return null;
  }

  public void setOrders(Collection<Order> newValue) {
      //this.orders = newValue;
  }
}
