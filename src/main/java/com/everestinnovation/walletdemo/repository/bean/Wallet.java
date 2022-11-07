package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeWallet;
    private int saldo;
    private String tipo;
}