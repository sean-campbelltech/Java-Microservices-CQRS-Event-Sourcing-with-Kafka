package com.springbank.account.query.repositories;

import com.springbank.account.common.models.BankAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccountRepository extends CrudRepository<BankAccount, String> {
}
