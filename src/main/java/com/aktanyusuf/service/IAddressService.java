package com.aktanyusuf.service;

import com.aktanyusuf.dto.DtoAddress;
import com.aktanyusuf.dto.DtoAddressIU;

public interface IAddressService {

	public DtoAddress create(DtoAddressIU dtoAddressIU);
	
}
