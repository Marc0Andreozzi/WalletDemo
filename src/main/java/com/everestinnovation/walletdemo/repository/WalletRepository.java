package com.everestinnovation.walletdemo.repository;

import com.everestinnovation.walletdemo.repository.bean.User;
import com.everestinnovation.walletdemo.repository.bean.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {

    Wallet save(Wallet wallet);

    public void deleteById(int id);

}