package com.everestinnovation.walletdemo.service;

import com.everestinnovation.walletdemo.exception.UserException;
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

    public boolean deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return true;
        }
        throw new UserException("Utente con id "+id+" non esiste!");
    }

    public User createUser(User user){
        if(user.getId()==null){
            log.info("User creato !");
            log.info(user.toString());
            userRepository.save(user);
        }else {
            userRepository.save(user);
        }
        return user;
    }

    public User getById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new WalletException("User con id "+id+" non esiste!");
    }

}
