package com.aktanyusuf.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aktanyusuf.controller.IRestCustomerController;
import com.aktanyusuf.controller.RestBaseController;
import com.aktanyusuf.dto.DtoCustomer;
import com.aktanyusuf.dto.DtoCustomerIU;
import com.aktanyusuf.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/customer")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController{

	@Autowired
	ICustomerService customerService;
	
	@PostMapping
	@Override
	public RootEntity<DtoCustomer> create(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
		return ok(customerService.create(dtoCustomerIU));
	}

}
