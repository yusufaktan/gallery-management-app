package com.aktanyusuf.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aktanyusuf.dto.DtoAccount;
import com.aktanyusuf.dto.DtoAddress;
import com.aktanyusuf.dto.DtoCustomer;
import com.aktanyusuf.dto.DtoCustomerIU;
import com.aktanyusuf.exception.BaseException;
import com.aktanyusuf.exception.ErrorMessage;
import com.aktanyusuf.exception.MessageType;
import com.aktanyusuf.model.Account;
import com.aktanyusuf.model.Address;
import com.aktanyusuf.model.Customer;
import com.aktanyusuf.repository.AccountRepository;
import com.aktanyusuf.repository.AddressRepository;
import com.aktanyusuf.repository.CustomerRepository;
import com.aktanyusuf.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public DtoCustomer create(DtoCustomerIU dtoCustomerIU) {
		Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
		if (optAddress.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.RESOURCE_NOT_FOUND, dtoCustomerIU.getAddressId().toString()));
		}

		Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
		if (optAccount.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.RESOURCE_NOT_FOUND, dtoCustomerIU.getAccountId().toString()));
		}

		Customer customer = new Customer();
		BeanUtils.copyProperties(dtoCustomerIU, customer);
		customer.setAddress(optAddress.get());
		customer.setAccount(optAccount.get());
		customer.setCreateTime(new Date());
		customerRepository.save(customer);

		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(customer.getAddress(), dtoAddress);

		DtoAccount dtoAccount = new DtoAccount();
		BeanUtils.copyProperties(customer.getAccount(), dtoAccount);

		DtoCustomer dtoCustomer = new DtoCustomer();
		BeanUtils.copyProperties(customer, dtoCustomer);
		dtoCustomer.setAddress(dtoAddress);
		dtoCustomer.setAccount(dtoAccount);

		return dtoCustomer;
	}

}
