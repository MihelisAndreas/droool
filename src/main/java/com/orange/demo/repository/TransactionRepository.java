package com.orange.demo.repository;

import com.orange.demo.model.User;
import com.orange.demo.model.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TransactionRepository extends JpaRepository<UserTransaction, Integer> {
    Collection<UserTransaction> findAllTransactionsByUser(User user);
}
