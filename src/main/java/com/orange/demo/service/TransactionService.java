package com.orange.demo.service;

import com.orange.demo.model.User;
import com.orange.demo.model.UserTransaction;

import java.util.Collection;

public interface TransactionService {
    User calculateCommission(User user);
    Collection<UserTransaction> findAll();
    UserTransaction create(double amount);
}
