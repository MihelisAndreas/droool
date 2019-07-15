package com.orange.demo.service;

import com.orange.demo.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}
