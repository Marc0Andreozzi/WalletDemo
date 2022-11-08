package com.everestinnovation.walletdemo.service;

import com.everestinnovation.walletdemo.repository.UserRepository;
import com.everestinnovation.walletdemo.repository.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.UsesJava7;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public Iterable<User> list(){
        return userRepository.findAll();
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User save(User user) {

            log.info("Utente salvato !");
            return userRepository.save(user);
    }
}
