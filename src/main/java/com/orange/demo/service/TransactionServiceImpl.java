package com.orange.demo.service;

import com.orange.demo.model.User;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    KieContainer kieContainer;

    @Override
    public User calculateCommission(User user) {
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(user);
        kieSession.fireAllRules();
        kieSession.dispose();
        return user;
    }
}
