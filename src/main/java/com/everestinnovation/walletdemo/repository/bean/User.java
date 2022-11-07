package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "utente")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;

    private String tipoUtenza;
    private String tipoWallet;

}