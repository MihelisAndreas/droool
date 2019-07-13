package com.orange.demo.service;

import com.orange.demo.model.User;
import com.orange.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllPersons() {
        List<User> persons = new ArrayList<User>();
        userRepository.findAll().forEach(person -> persons.add(person));
        return persons;
    }

    @Override
    public User getPersonById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User login(String email, String password) {
        User user = getPersonById(email);
        return user.getPassword().equals(password) ?  user : null;
    }
}
