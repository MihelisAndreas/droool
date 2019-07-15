package com.orange.demo.service;

import com.orange.demo.model.User;
import com.orange.demo.model.UserTransaction;
import com.orange.demo.repository.TransactionRepository;
import com.orange.demo.repository.UserRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    KieContainer kieContainer;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public User calculateCommission(User user) {
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(user);
        kieSession.fireAllRules();
        kieSession.dispose();
        return user;
    }

    @Override
    public Collection<UserTransaction> findAll() {
        String userEmail = securityService.findLoggedInUsername();
        User user = userRepository.findByEmail(userEmail);
        return transactionRepository.findAllTransactionsByUser(user);
    }

    @Override
    public UserTransaction create(double amount) {
        String userEmail = securityService.findLoggedInUsername();
        User user = userRepository.findByEmail(userEmail);
        UserTransaction userTransaction = new UserTransaction();
        userTransaction.setUser(user);
        userTransaction.setAmount(amount);
        return transactionRepository.save(userTransaction);
    }

}
