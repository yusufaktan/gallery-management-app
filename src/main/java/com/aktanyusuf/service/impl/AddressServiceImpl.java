package com.aktanyusuf.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktanyusuf.dto.DtoAddress;
import com.aktanyusuf.dto.DtoAddressIU;
import com.aktanyusuf.model.Address;
import com.aktanyusuf.repository.AddressRepository;
import com.aktanyusuf.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public DtoAddress create(DtoAddressIU dtoAddressIU) {
		Address address = new Address();
		BeanUtils.copyProperties(dtoAddressIU, address);
		addressRepository.save(address);
		
		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(address, dtoAddress);

		return dtoAddress;
	}

}
