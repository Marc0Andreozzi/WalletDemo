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
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    public Iterable<User> list(){
        return userRepository.findAll();
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteById(User user){

     //  if(user.getId()..{
            //throw new UserNotFoundException("user " + user);
       // }
        log.info("Utente cancellato !");
        userRepository.deleteById(user.getId());
    }

    public void saveUserAndWallet(User user, Wallet wallet) {

            log.info("Utente creato con il rispettivo Wallet di default !");
            userRepository.save(user);
            walletRepository.save(wallet);
    }


}
