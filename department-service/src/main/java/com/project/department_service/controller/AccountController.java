package com.project.department_service.controller;


import com.project.department_service.dto.AccountDTO;
import com.project.department_service.entity.Account;
import com.project.department_service.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/accounts")
public class AccountController {

    private final IAccountService acService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<AccountDTO> getListAccounts() {
        List<Account> accounts = acService.getListAccounts();

        List<AccountDTO>  accountDTOS = modelMapper.map(
                accounts,
                new TypeToken<List<AccountDTO>>() {}.getType());
        return accountDTOS;
    }
}
