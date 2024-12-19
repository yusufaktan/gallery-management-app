package com.aktanyusuf.controller;

import com.aktanyusuf.controller.impl.RootEntity;
import com.aktanyusuf.dto.DtoAccount;
import com.aktanyusuf.dto.DtoAccountIU;

public interface IRestAccountController {

	public RootEntity<DtoAccount> create(DtoAccountIU dtoAccountIU);
	
}
