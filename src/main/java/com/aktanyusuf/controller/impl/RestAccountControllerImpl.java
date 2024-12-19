package com.aktanyusuf.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aktanyusuf.controller.IRestAccountController;
import com.aktanyusuf.controller.RestBaseController;
import com.aktanyusuf.dto.DtoAccount;
import com.aktanyusuf.dto.DtoAccountIU;
import com.aktanyusuf.service.impl.AccountServiceImpl;

@RestController
@RequestMapping("/rest/api/account")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController {

	@Autowired
	AccountServiceImpl accountService;

	@PostMapping
	@Override
	public RootEntity<DtoAccount> create(DtoAccountIU dtoAccountIU) {
		return ok(accountService.create(dtoAccountIU));
	}

}
