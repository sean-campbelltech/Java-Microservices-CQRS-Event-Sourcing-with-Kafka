package com.springbank.account.query.handlers;

import com.springbank.account.query.queries.FindAccountByHolderQuery;
import com.springbank.account.query.queries.FindAccountByIdQuery;
import com.springbank.account.query.queries.FindAccountsWithBalanceQuery;
import com.springbank.account.query.queries.FindAllAccountsQuery;
import com.springbank.cqrs.core.domain.BaseEntity;

import java.util.List;

public interface AccountQueryHandler {
    List<BaseEntity> handle(FindAllAccountsQuery query);
    List<BaseEntity> handle(FindAccountByIdQuery query);
    List<BaseEntity> handle(FindAccountByHolderQuery query);
    List<BaseEntity> handle(FindAccountsWithBalanceQuery query);
}
