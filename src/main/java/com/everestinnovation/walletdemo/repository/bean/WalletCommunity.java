package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "wallet_community")
public class WalletCommunity implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nome_wallet")
    private String nomeWallet;

    @Column(name= "saldo")
    private int saldo;

    @OneToOne
    @JoinColumn(name = "id_wallet", referencedColumnName = "id")
    private Wallet wallet;

    @OneToOne
    @JoinColumn(name = "id_cred", referencedColumnName = "id")
    private Credenziali credenziali;

    @OneToOne
    @JoinColumn(name = "id_ruolo", referencedColumnName = "id")
    private RuoloUtenteWallet ruoloUtenteWallet;

}
