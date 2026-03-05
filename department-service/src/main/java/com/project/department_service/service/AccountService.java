package com.project.department_service.service;

import com.project.department_service.entity.Account;
import com.project.department_service.repository.IAccountRepository;
import com.project.department_service.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final IAccountRepository acRepository;

    @Override
    public List<Account> getListAccounts() {
        return acRepository.findAll();
    }
}
