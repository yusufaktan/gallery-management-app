package com.aktanyusuf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aktanyusuf.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
