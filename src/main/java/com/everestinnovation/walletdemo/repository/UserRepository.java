package com.everestinnovation.walletdemo.repository;


import com.everestinnovation.walletdemo.repository.bean.User;
import com.everestinnovation.walletdemo.repository.bean.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {



    public void deleteById(long id);


}
