package com.everestinnovation.walletdemo.repository.bean;

import com.everestinnovation.walletdemo.repository.enums.TipoWalletEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "id_cred", referencedColumnName = "id")
    private Credenziali credenziali;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "id_tipo_wallet",referencedColumnName = "idTipoWallet")
    private TipoWalletEnum tipoWalletEnum;


}