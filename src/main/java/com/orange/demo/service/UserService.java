package com.orange.demo.service;

import com.orange.demo.model.User;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

}
