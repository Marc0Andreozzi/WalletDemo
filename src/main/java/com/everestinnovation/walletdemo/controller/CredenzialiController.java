package com.everestinnovation.walletdemo.controller;

import com.everestinnovation.walletdemo.repository.bean.Credenziali;
import com.everestinnovation.walletdemo.repository.bean.Wallet;
import com.everestinnovation.walletdemo.service.CredenzialiService;
import com.everestinnovation.walletdemo.service.ValidationErrorService;
import com.everestinnovation.walletdemo.service.WalletService;
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
    private CredenzialiService credenzialiService;

    @Autowired
    private WalletService walletService;

    public UserController (CredenzialiService credenzialiService) { this.credenzialiService = credenzialiService; }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Credenziali credenziali, Wallet wallet, BindingResult result){
        ResponseEntity errors = validationErrorService.validate(result);
        if(errors != null) return errors;
        log.info("Richiesta ricevuta per creare un nuovo Utente.", LogLevel.INFO);
        Credenziali credenzialiSaved = credenzialiService.createUser(credenziali,wallet);

        return new ResponseEntity<Credenziali>(credenzialiSaved,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        credenzialiService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(credenzialiService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/list")
    public Iterable<Credenziali> list(){
        return credenzialiService.list();
    }


}
