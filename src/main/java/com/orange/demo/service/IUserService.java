package com.orange.demo.service;

import com.orange.demo.model.User;

import java.util.List;

public interface IUserService {

    public List<User> getAllPersons();

    public User getPersonById(String id);

    public void saveOrUpdate(User user);

    public void delete(String id);

    public User login(String email, String password);
}
