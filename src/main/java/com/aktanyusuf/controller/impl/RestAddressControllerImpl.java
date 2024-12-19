package com.aktanyusuf.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aktanyusuf.controller.IRestAddressController;
import com.aktanyusuf.controller.RestBaseController;
import com.aktanyusuf.dto.DtoAddress;
import com.aktanyusuf.dto.DtoAddressIU;
import com.aktanyusuf.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {

	@Autowired
	IAddressService addressService;
	
	@PostMapping
	@Override
	public RootEntity<DtoAddress> create(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
		return ok(addressService.create(dtoAddressIU));
	}

}
