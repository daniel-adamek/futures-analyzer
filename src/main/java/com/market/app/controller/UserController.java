package com.market.app.controller;


import com.market.app.model.User;
import com.market.app.service.SecurityService;
import com.market.app.service.UserService;
import com.market.app.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @PostMapping("/register")
    public ResponseEntity<User> registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        System.out.println(userForm);
        userService.save(userForm);
        //securityService.autoLogin(userForm.getUsername(),userForm.getPasswordConfirm());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
