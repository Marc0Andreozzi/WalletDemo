package com.everestinnovation.walletdemo.repository;


import com.everestinnovation.walletdemo.repository.bean.Credenziali;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CredenzialiRepository extends JpaRepository<Credenziali, Long> {



    public void deleteById(long id);


}
