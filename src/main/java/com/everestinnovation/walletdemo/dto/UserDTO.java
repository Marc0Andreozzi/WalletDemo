package com.everestinnovation.walletdemo.dto;

import com.everestinnovation.walletdemo.repository.bean.Wallet;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserDTO {

    private Long id;
    private String email;
    private String username;
    private String password;
    private String confermaPassword;
    private String tipoUtenza;
    private List<Wallet> wallet;
}
