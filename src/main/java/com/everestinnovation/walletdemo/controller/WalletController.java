package com.everestinnovation.walletdemo.controller;

import com.everestinnovation.walletdemo.repository.bean.User;
import com.everestinnovation.walletdemo.repository.bean.Wallet;
import com.everestinnovation.walletdemo.service.UserService;
import com.everestinnovation.walletdemo.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    public WalletController (WalletService walletService) { this.walletService = walletService; }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createWallet (

            @Valid @RequestBody Wallet wallet){
        log.info("Richiesta ricevuta per creare un nuovo Utente.", LogLevel.INFO);
        log.info(wallet.toString());

        walletService.save(wallet);

    }

    @DeleteMapping("/{id}")
    public void deleteWallet(Wallet wallet){

        log.info("Richiesta ricevuta per cancellare un Utente.", LogLevel.INFO);
        String walletId = String.valueOf(wallet.getId());
        log.info("Id: " + walletId);

        walletService.deleteById(wallet);
    }



    @GetMapping("/list")
    public Iterable<Wallet> list(){
        return walletService.list();
    }

}
