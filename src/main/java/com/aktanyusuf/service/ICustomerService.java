package com.aktanyusuf.service;

import com.aktanyusuf.dto.DtoCustomer;
import com.aktanyusuf.dto.DtoCustomerIU;

public interface ICustomerService {

	public DtoCustomer create(DtoCustomerIU dtoCustomerIU);
	
}
