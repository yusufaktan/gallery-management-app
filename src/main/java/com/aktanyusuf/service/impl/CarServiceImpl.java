package com.aktanyusuf.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktanyusuf.dto.DtoCar;
import com.aktanyusuf.dto.DtoCarIU;
import com.aktanyusuf.model.Car;
import com.aktanyusuf.repository.CarRepository;
import com.aktanyusuf.service.ICarService;

@Service
public class CarServiceImpl implements ICarService{

	@Autowired
	CarRepository carRepository;
	
	@Override
	public DtoCar create(DtoCarIU dtoCarIU) {
		Car car = new Car();
		BeanUtils.copyProperties(dtoCarIU, car);
		car.setCreateTime(new Date());
		carRepository.save(car);
		
		DtoCar dtoCar = new DtoCar();
		BeanUtils.copyProperties(car, dtoCar);
		
		return dtoCar;
	}

}
