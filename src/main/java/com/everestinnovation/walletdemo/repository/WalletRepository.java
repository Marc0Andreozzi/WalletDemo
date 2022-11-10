package com.everestinnovation.walletdemo.repository;


import com.everestinnovation.walletdemo.repository.bean.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet save(Wallet wallet);

    public void deleteById(long id);

}