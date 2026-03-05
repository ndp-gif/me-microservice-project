package com.project.account_service.service;

import com.project.account_service.entity.Account;
import com.project.account_service.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService{

    private final IAccountRepository acRepository;

    @Override
    public List<Account> getListAccounts() {
        return acRepository.findAll();
    }

    @Override
    public Account findAccountById(Long id) {
        final Optional<Account> accountEntityOpt = acRepository.findById(id);
        return accountEntityOpt.orElse(null);
    }
}
