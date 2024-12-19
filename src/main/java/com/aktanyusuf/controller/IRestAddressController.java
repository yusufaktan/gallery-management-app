package com.aktanyusuf.controller;

import com.aktanyusuf.controller.impl.RootEntity;
import com.aktanyusuf.dto.DtoAddress;
import com.aktanyusuf.dto.DtoAddressIU;

public interface IRestAddressController {

	public RootEntity<DtoAddress> create(DtoAddressIU dtoAddressIU);
	
}
