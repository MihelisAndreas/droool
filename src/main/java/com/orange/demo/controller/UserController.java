package com.orange.demo.controller;

import com.orange.demo.model.User;
import com.orange.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody User user) {
    iUserService.saveOrUpdate(user);

    return new ResponseEntity<String>("",null, HttpStatus.ACCEPTED);
}

//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody @NotNull String email,@NotNull String password) {
//    iUserService.validateUser();
//    return new ResponseEntity<String>(new User,null, HttpStatus.ACCEPTED);
//}

}
