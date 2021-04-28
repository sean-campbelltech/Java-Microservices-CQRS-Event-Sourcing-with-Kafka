package com.springbank.account.query.api.queries;

import com.springbank.account.query.api.queries.FindAccountByHolderQuery;
import com.springbank.account.query.api.queries.FindAccountByIdQuery;
import com.springbank.account.query.api.queries.FindAccountsWithBalanceQuery;
import com.springbank.account.query.api.queries.FindAllAccountsQuery;
import com.springbank.cqrs.core.domain.BaseEntity;

import java.util.List;

public interface AccountQueryHandler {
    List<BaseEntity> handle(FindAllAccountsQuery query);
    List<BaseEntity> handle(FindAccountByIdQuery query);
    List<BaseEntity> handle(FindAccountByHolderQuery query);
    List<BaseEntity> handle(FindAccountsWithBalanceQuery query);
}
