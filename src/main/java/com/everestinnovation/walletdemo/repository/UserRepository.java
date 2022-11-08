package com.everestinnovation.walletdemo.repository;


import com.everestinnovation.walletdemo.repository.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User save(User user);
}
