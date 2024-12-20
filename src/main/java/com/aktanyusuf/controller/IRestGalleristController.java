package com.aktanyusuf.controller;

import com.aktanyusuf.controller.impl.RootEntity;
import com.aktanyusuf.dto.DtoGallerist;
import com.aktanyusuf.dto.DtoGalleristIU;

public interface IRestGalleristController {

	public RootEntity<DtoGallerist> create(DtoGalleristIU dtoGalleristIU);
	
}
