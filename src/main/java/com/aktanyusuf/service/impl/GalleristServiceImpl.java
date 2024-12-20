package com.aktanyusuf.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aktanyusuf.dto.DtoAddress;
import com.aktanyusuf.dto.DtoGallerist;
import com.aktanyusuf.dto.DtoGalleristIU;
import com.aktanyusuf.exception.BaseException;
import com.aktanyusuf.exception.ErrorMessage;
import com.aktanyusuf.exception.MessageType;
import com.aktanyusuf.model.Address;
import com.aktanyusuf.model.Gallerist;
import com.aktanyusuf.repository.AddressRepository;
import com.aktanyusuf.repository.GalleristRepository;
import com.aktanyusuf.service.IGalleristService;

public class GalleristServiceImpl implements IGalleristService{

	@Autowired
	GalleristRepository galleristRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public DtoGallerist create(DtoGalleristIU dtoGalleristIU) {
		Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
		if (optAddress.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.RESOURCE_NOT_FOUND, dtoGalleristIU.getAddressId().toString()));
		}
		
		Gallerist gallerist = new Gallerist();
		gallerist.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoGalleristIU, gallerist);
		gallerist.setAddress(optAddress.get());
		galleristRepository.save(gallerist);
		
		DtoGallerist dtoGallerist = new DtoGallerist();
		BeanUtils.copyProperties(gallerist, dtoGallerist);
		
		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(optAddress, dtoAddress);
		
		dtoGallerist.setAddress(dtoAddress);
		
		return dtoGallerist;
	}

}
