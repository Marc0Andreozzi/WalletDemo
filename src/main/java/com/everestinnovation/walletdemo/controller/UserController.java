package com.everestinnovation.walletdemo.controller;

import com.everestinnovation.walletdemo.repository.bean.User;
import com.everestinnovation.walletdemo.repository.bean.Wallet;
import com.everestinnovation.walletdemo.service.UserService;
import com.everestinnovation.walletdemo.service.ValidationErrorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ValidationErrorService validationErrorService;
    @Autowired
    private UserService userService;

    public UserController (UserService userService) { this.userService=userService; }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result){
        ResponseEntity errors = validationErrorService.validate(result);
        if(errors != null) return errors;
        log.info("Richiesta ricevuta per creare un nuovo Wallet.", LogLevel.INFO);
        User userSaved = userService.createUser(user);
        return new ResponseEntity<User>(userSaved,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/list")
    public Iterable<User> list(){
        return userService.list();
    }


}
