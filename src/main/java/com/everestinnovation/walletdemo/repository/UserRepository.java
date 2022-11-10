package com.everestinnovation.walletdemo.repository;


import com.everestinnovation.walletdemo.repository.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    public void deleteById(long id);



}
