package com.springbank.account.query.api.queries;

import com.springbank.account.query.api.dto.EqualityType;
import com.springbank.cqrs.core.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindAccountsWithBalanceQuery extends BaseQuery {
    private EqualityType equalityType;
    private double balance;
}
