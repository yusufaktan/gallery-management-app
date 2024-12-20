package com.aktanyusuf.controller;

import com.aktanyusuf.controller.impl.RootEntity;
import com.aktanyusuf.dto.DtoCar;
import com.aktanyusuf.dto.DtoCarIU;

public interface IRestCarController {

	public RootEntity<DtoCar> create(DtoCarIU dtoCarIU);

}
