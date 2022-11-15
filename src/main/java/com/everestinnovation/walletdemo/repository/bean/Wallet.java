package com.everestinnovation.walletdemo.repository.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "wallet")
public class Wallet {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nome_wallet")
    private String nomeWallet;

    @Column(name= "saldo")
    private int saldo;

    private String tipo;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}