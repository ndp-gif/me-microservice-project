package com.project.account_service.repository;

import com.project.account_service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
}
