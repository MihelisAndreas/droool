package com.orange.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="users",schema="main")
public class User {

    @NotNull
    @Size(min = 2, max = 30)
   private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
   private String lastName;

    @Id
    @NotNull
    @Email
   private String email;

    @NotNull
    @Size(min = 6, max = 30)
   private String password;

    private int numberOfTransactions;

    private int commission;

    private int transactionTotal;

    @ManyToMany
    private Set<Role> roles;

    @OneToMany(mappedBy="User")
    private Set<Transaction> transactions;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getNumberOfTransactions() {
        return transactions.size();
    }

    public double getTotalTransactionAmount() {
        double ammount = 0;
        for (Transaction t : transactions) {
            ammount += t.getAmount();
        }
        return ammount;
    }
}
