package com.aktanyusuf.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aktanyusuf.controller.IRestGalleristCarController;
import com.aktanyusuf.controller.RestBaseController;
import com.aktanyusuf.dto.DtoGalleristCar;
import com.aktanyusuf.dto.DtoGalleristCarIU;
import com.aktanyusuf.service.IGalleristCarService;

@RestController
@RequestMapping("/rest/api/galleristCar")
public class RestGalleristCarController extends RestBaseController implements IRestGalleristCarController {

	@Autowired
	IGalleristCarService galleristCarService;

	@PostMapping
	@Override
	public RootEntity<DtoGalleristCar> create(DtoGalleristCarIU dtoGalleristCarIU) {
		return ok(galleristCarService.create(dtoGalleristCarIU));
	}

}
