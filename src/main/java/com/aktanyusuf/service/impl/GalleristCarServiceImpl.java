package com.aktanyusuf.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktanyusuf.dto.DtoCar;
import com.aktanyusuf.dto.DtoGallerist;
import com.aktanyusuf.dto.DtoGalleristCar;
import com.aktanyusuf.dto.DtoGalleristCarIU;
import com.aktanyusuf.exception.BaseException;
import com.aktanyusuf.exception.ErrorMessage;
import com.aktanyusuf.exception.MessageType;
import com.aktanyusuf.model.Car;
import com.aktanyusuf.model.Gallerist;
import com.aktanyusuf.model.GalleristCar;
import com.aktanyusuf.repository.CarRepository;
import com.aktanyusuf.repository.GalleristCarRepository;
import com.aktanyusuf.repository.GalleristRepository;
import com.aktanyusuf.service.IGalleristCarService;

@Service
public class GalleristCarServiceImpl implements IGalleristCarService {

	@Autowired
	GalleristCarRepository galleristCarRepository;

	@Autowired
	GalleristRepository galleristRepository;

	@Autowired
	CarRepository carRepository;

	@Override
	public DtoGalleristCar create(DtoGalleristCarIU dtoGalleristCarIU) {
		Optional<Gallerist> optGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
		if (optGallerist.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.RESOURCE_NOT_FOUND, dtoGalleristCarIU.getGalleristId().toString()));
		}

		Optional<Car> optCar = carRepository.findById(dtoGalleristCarIU.getCarId());
		if (optCar.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.RESOURCE_NOT_FOUND, dtoGalleristCarIU.getCarId().toString()));
		}

		GalleristCar galleristCar = new GalleristCar();
		BeanUtils.copyProperties(dtoGalleristCarIU, galleristCar);
		galleristCar.setCreateTime(new Date());
		galleristCar.setCar(optCar.get());
		galleristCar.setGallerist(optGallerist.get());

		DtoGallerist dtoGallerist = new DtoGallerist();
		BeanUtils.copyProperties(galleristCar.getGallerist(), dtoGallerist);

		DtoCar dtoCar = new DtoCar();
		BeanUtils.copyProperties(galleristCar.getCar(), dtoCar);

		DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
		BeanUtils.copyProperties(galleristCar, dtoGalleristCar);
		dtoGalleristCar.setCar(dtoCar);
		dtoGalleristCar.setGallerist(dtoGallerist);

		return dtoGalleristCar;

	}
}
