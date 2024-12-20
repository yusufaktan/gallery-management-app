package com.aktanyusuf.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aktanyusuf.controller.IRestCarController;
import com.aktanyusuf.controller.RestBaseController;
import com.aktanyusuf.dto.DtoCar;
import com.aktanyusuf.dto.DtoCarIU;
import com.aktanyusuf.service.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {

	@Autowired
	ICarService carService;

	@Override
	public RootEntity<DtoCar> create(@Valid @RequestBody DtoCarIU dtoCarIU) {
		return ok(carService.create(dtoCarIU));
	}

}
