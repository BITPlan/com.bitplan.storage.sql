package com.bitplan.testentity;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import javax.persistence.Table;

import com.bitplan.storage.sql.JPABOImpl;

@Entity(name = "Order")
@Table(name = "Order_Table")
public class OrderJPAOld 
// extends JPABOImpl<Order> 
implements Order {
	@Id
	@Column(name = "ORDER_ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String address;
	@Transient
	Long customerId;
	private CustomerJPAOld customer;

	@ManyToOne()
	@JoinColumn(name = "CUSTOMER_ID")
	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public void setCustomer(Customer pCustomer) {
		this.customer = (CustomerJPAOld) pCustomer;
		if (pCustomer!=null) {
			customerId=pCustomer.getId();
		}
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long pid) {
		id = pid;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String paddress) {
		address = paddress;
	}

	@Override
	public long getCustomerId() {
		return customerId;
	}

	@Override
	public void setCustomerId(long pcustomerId) {
		customerId = pcustomerId;
	}

	//@Override
	@Transient
	public Object getPrimaryKey() {
		return getId();
	}
}
