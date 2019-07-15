package com.orange.demo.controller;
import javax.validation.Valid;

import com.orange.demo.model.User;
import com.orange.demo.model.UserTransaction;
import com.orange.demo.service.SecurityService;
import com.orange.demo.service.TransactionService;
import com.orange.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("user/login");
        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");
        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {
            //try catch
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            securityService.autologin(user.getEmail(), user.getPassword());
            model.setViewName("transactions/transact");
        }
        return model;
    }

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }

    @RequestMapping(value= {"/transact"}, method=RequestMethod.GET)
    public ModelAndView transact() {
        Collection<UserTransaction> userTransactions = transactionService.findAll();
        ModelAndView model = new ModelAndView();
        model.addObject("transactions", userTransactions);
        model.addObject("form", new UserTransaction());
        model.setViewName("transactions/transact");
        return model;
    }

    @RequestMapping(value= {"/transactions/save"}, method=RequestMethod.POST)
    public ModelAndView createTrans(@Valid UserTransaction tr, BindingResult bindingResult) {
        transactionService.create(tr.getAmount());
        ModelAndView model = new ModelAndView();
        model.addObject("form",new UserTransaction());
        Collection<UserTransaction> userTransactions = transactionService.findAll();
        model.addObject("transactions", userTransactions);
        model.setViewName("transactions/transact");
        return model;
    }
}

