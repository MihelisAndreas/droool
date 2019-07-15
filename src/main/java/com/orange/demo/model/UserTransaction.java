package com.orange.demo.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_transaction")
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="amount")
    private double amount;

    @Column(name="transaction_date")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date transactionDate;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
