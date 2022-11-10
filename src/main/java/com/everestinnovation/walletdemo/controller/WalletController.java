package com.everestinnovation.walletdemo.controller;

import com.everestinnovation.walletdemo.repository.bean.User;
import com.everestinnovation.walletdemo.repository.bean.Wallet;
import com.everestinnovation.walletdemo.service.UserService;
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
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private ValidationErrorService validationErrorService;
    @Autowired
    private WalletService walletService;

    public WalletController (WalletService walletService) { this.walletService = walletService; }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Wallet wallet, BindingResult result){
        ResponseEntity errors = validationErrorService.validate(result);
        if(errors != null) return errors;
        Wallet walletSaved = walletService.createWallet(wallet);
        return new ResponseEntity<Wallet>(walletSaved,HttpStatus.CREATED);
    }

    
    @GetMapping("/list")
    public Iterable<Wallet> list(){
        return walletService.list();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(walletService.getById(id),HttpStatus.OK);
    }

}
