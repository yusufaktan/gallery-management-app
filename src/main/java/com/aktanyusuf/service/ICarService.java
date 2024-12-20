package com.aktanyusuf.service;

import com.aktanyusuf.dto.DtoCar;
import com.aktanyusuf.dto.DtoCarIU;

public interface ICarService {
	
	public DtoCar create(DtoCarIU dtoCarIU);

}
