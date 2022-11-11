package com.everestinnovation.walletdemo.dto;

import com.everestinnovation.walletdemo.repository.bean.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WalletDTO {

    private Long id;
    private String nomeWallet;
    private int saldo;
    private String tipo;
    private User user;
}
