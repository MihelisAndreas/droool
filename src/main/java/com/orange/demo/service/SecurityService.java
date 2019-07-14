package com.orange.demo.service;

public interface SecurityService {

    String findLoggedInUser();

    void autoLogin(String email, String password);
}
