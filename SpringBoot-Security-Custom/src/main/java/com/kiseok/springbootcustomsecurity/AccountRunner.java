package com.kiseok.springbootcustomsecurity;

import com.kiseok.springbootcustomsecurity.account.Account;
import com.kiseok.springbootcustomsecurity.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = accountService.createAccount("kiseok", "1234");
        System.out.println("username : " + account.getUsername() + ", password : " + account.getPassword());
    }
}
