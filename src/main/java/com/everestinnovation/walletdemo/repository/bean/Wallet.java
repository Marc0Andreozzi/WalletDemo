package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wallet")
public class Wallet {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "nome_wallet")
    private String nomeWallet;

    @Column(name= "saldo")
    private int saldo;

    private String tipo;
}