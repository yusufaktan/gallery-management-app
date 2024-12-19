package com.aktanyusuf.service;

import com.aktanyusuf.dto.DtoAccount;
import com.aktanyusuf.dto.DtoAccountIU;

public interface IAccountService {

	public DtoAccount create(DtoAccountIU dtoAccountIU);
	
}
