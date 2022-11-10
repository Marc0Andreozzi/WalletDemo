package com.everestinnovation.walletdemo.controller;

import com.everestinnovation.walletdemo.repository.bean.User;
import com.everestinnovation.walletdemo.repository.bean.Wallet;
import com.everestinnovation.walletdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController (UserService userService) { this.userService=userService; }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createUser (
            @Valid @RequestBody User user,
            @Valid @RequestBody Wallet wallet){

        log.info("Richiesta ricevuta per creare un nuovo Utente.", LogLevel.INFO);
        log.info(user.toString());
        log.info(wallet.toString());

        userService.saveUserAndWallet(user,wallet);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(User user){

        log.info("Richiesta ricevuta per cancellare un Utente.", LogLevel.INFO);
        String userdId = String.valueOf(user.getId());
        log.info("Id: " + userdId);

        userService.deleteById(user);
    }



    @GetMapping("/list")
    public Iterable<User> list(){
        return userService.list();
    }


}
