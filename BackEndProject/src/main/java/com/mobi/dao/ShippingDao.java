package com.mobi.dao;

import java.util.List;

import com.mobi.Model.Shipping;



public interface ShippingDao {
	
		int SaveOrUpdate(Shipping shipping);
		List<Shipping>getAllShipping();
		Shipping getShippingBy(int shippingId);
		int deleteShippingById(int shippingId);
}
