package com.everestinnovation.walletdemo.service;

import com.everestinnovation.walletdemo.exception.UserException;
import com.everestinnovation.walletdemo.exception.WalletException;
import com.everestinnovation.walletdemo.repository.UserRepository;
import com.everestinnovation.walletdemo.repository.WalletRepository;
import com.everestinnovation.walletdemo.repository.bean.Credenziali;
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

    public Iterable<Credenziali> list(){
        return userRepository.findAll();
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean deleteUser(Long id)throws UserException{
        Optional<Credenziali> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            log.info("Utente Cancellato !");
            return true;
        }
        throw new UserException("Utente con id "+id+" non esiste!");
    }

    public Credenziali createUser(Credenziali credenziali, Wallet wallet){
        if(credenziali.getId()==null){
            log.info("Utente creato !");
            log.info(credenziali.toString());
            userRepository.save(credenziali);

         /*    wallet.setNomeWallet("WalletDefault");
             wallet.setSaldo(0);
             wallet.setTipo("Default");
             wallet.setUser(user);
             walletRepository.save(wallet);
*/
        }else {
            userRepository.save(credenziali);
        }
        return credenziali;
    }

    /*public User update(Long walletId, Long userId, User user){

        User updatedUser = userRepository.findById(userId).get();
        Wallet wallet = walletRepository.findById(walletId).get();

        updatedUser.getWallet().add(wallet);
        userRepository.save(updatedUser);

        return updatedUser;
    }*/

    public Credenziali getById(Long id){
        Optional<Credenziali> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new WalletException("User con id "+id+" non esiste!");
    }

}
