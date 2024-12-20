package com.aktanyusuf.controller;

import com.aktanyusuf.controller.impl.RootEntity;
import com.aktanyusuf.dto.DtoGalleristCar;
import com.aktanyusuf.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {

	public RootEntity<DtoGalleristCar> create(DtoGalleristCarIU dtoGalleristCarIU);

}
