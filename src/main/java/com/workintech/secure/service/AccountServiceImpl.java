package com.workintech.secure.service;

import com.workintech.secure.dao.AccountRepository;
import com.workintech.secure.entity.Account;

import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()){
            return account.get();
        }
        return null;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(int id) {
        Account account = findById(id);
        accountRepository.delete(account);
        return account;
    }
}
