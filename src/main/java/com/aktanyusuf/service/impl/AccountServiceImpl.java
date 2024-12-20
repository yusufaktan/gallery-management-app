package com.aktanyusuf.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aktanyusuf.dto.DtoAccount;
import com.aktanyusuf.dto.DtoAccountIU;
import com.aktanyusuf.model.Account;
import com.aktanyusuf.repository.AccountRepository;
import com.aktanyusuf.service.IAccountService;

public class AccountServiceImpl implements IAccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public DtoAccount create(DtoAccountIU dtoAccountIU) {
		Account account = new Account();
		BeanUtils.copyProperties(dtoAccountIU, account);
		account.setCreateTime(new Date());
		accountRepository.save(account);
		
		DtoAccount dtoAccount = new DtoAccount();
		BeanUtils.copyProperties(account, dtoAccount);
		
		return dtoAccount;
	}

}
