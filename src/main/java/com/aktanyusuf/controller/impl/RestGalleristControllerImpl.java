package com.aktanyusuf.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aktanyusuf.controller.IRestGalleristController;
import com.aktanyusuf.controller.RestBaseController;
import com.aktanyusuf.dto.DtoGallerist;
import com.aktanyusuf.dto.DtoGalleristIU;
import com.aktanyusuf.service.IGalleristService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/gallerist")
public class RestGalleristControllerImpl extends RestBaseController implements IRestGalleristController{

	@Autowired
	IGalleristService galleristService;
	
	@PostMapping
	@Override
	public RootEntity<DtoGallerist> create(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
		return ok(galleristService.create(dtoGalleristIU));
	}

}
