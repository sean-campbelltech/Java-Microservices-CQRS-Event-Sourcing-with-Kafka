package com.springbank.account.query.handlers;

import com.springbank.account.common.models.BankAccount;
import com.springbank.account.query.queries.FindAccountByHolderQuery;
import com.springbank.account.query.queries.FindAccountByIdQuery;
import com.springbank.account.query.queries.FindAccountsWithBalanceQuery;
import com.springbank.account.query.queries.FindAllAccountsQuery;
import com.springbank.account.query.repositories.AccountRepository;
import com.springbank.cqrs.core.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountQueryHandlerImpl implements AccountQueryHandler {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<BaseEntity> handle(FindAllAccountsQuery query) {
        Iterable<BankAccount> bankAccounts = accountRepository.findAll();
        List<BaseEntity> bankAccountsList = new ArrayList<>();
        bankAccounts.forEach(bankAccountsList::add);
        return bankAccountsList;
    }

    @Override
    public List<BaseEntity> handle(FindAccountByIdQuery query) {
        return null;
    }

    @Override
    public List<BaseEntity> handle(FindAccountByHolderQuery query) {
        return null;
    }

    @Override
    public List<BaseEntity> handle(FindAccountsWithBalanceQuery query) {
        return null;
    }
}
