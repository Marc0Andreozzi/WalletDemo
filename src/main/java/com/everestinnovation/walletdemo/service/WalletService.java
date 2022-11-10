package com.everestinnovation.walletdemo.service;

import com.everestinnovation.walletdemo.exception.WalletException;
import com.everestinnovation.walletdemo.repository.UserRepository;
import com.everestinnovation.walletdemo.repository.WalletRepository;
import com.everestinnovation.walletdemo.repository.bean.User;
import com.everestinnovation.walletdemo.repository.bean.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Wallet getById(Long id){
        Optional<Wallet> wallet = walletRepository.findById(id);
        if(wallet.isPresent()){
            return wallet.get();
        }
        throw new WalletException("Wallet con id "+id+" non esiste!");
    }
    public Wallet createWallet(Wallet wallet){
        if(wallet.getId()==null){
            log.info("Wallet creato !");
            log.info(wallet.toString());
            walletRepository.save(wallet);
        }else {
            walletRepository.save(wallet);
        }
        return wallet;
    }
}

