package com.everestinnovation.walletdemo.service;

import com.everestinnovation.walletdemo.repository.UserRepository;
import com.everestinnovation.walletdemo.repository.WalletRepository;
import com.everestinnovation.walletdemo.repository.bean.User;
import com.everestinnovation.walletdemo.repository.bean.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private WalletRepository walletRepository;

    public Iterable<Wallet> list(){
        return walletRepository.findAll();
    }

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public void deleteById(Wallet wallet){

        //  if(wallet.getId()..{
        //throw new WalletNotFoundException("wallet " + wallet);
        // }
        log.info("Wallet cancellato !");
        walletRepository.deleteById(wallet.getId());
    }

    public Wallet save(Wallet wallet) {

        log.info("Wallet salvato !");
        return walletRepository.save(wallet);
    }
}

