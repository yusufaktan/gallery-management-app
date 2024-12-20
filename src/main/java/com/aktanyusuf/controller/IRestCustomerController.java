package com.aktanyusuf.controller;

import com.aktanyusuf.controller.impl.RootEntity;
import com.aktanyusuf.dto.DtoCustomer;
import com.aktanyusuf.dto.DtoCustomerIU;

public interface IRestCustomerController {

	public RootEntity<DtoCustomer> create(DtoCustomerIU dtoCustomerIU);

}
