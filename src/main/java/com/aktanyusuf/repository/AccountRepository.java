package com.aktanyusuf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aktanyusuf.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
