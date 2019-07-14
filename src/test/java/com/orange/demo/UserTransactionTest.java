package com.orange.demo;

import com.orange.demo.model.User;
import com.orange.demo.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTransactionTest {

    @Autowired
    TransactionService transactionService;

    @Test
    public void caclulatedCommissionTest() {
        User user = new User();
        user.setTotalTransactionAmount(6000);
        user.setTransactionCount(6);
        user = transactionService.calculateCommission(user);

        assertNotNull(user);
        assertEquals(10, user.getCommission());
    }
}
