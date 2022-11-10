package com.everestinnovation.walletdemo.repository.bean;


import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity
@Table(name = "utente")
public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "email",unique = true, nullable = false)
    @Size(max = 254, message = "Email può contenere fino a 254 caratteri")
    @Pattern(regexp = "[^@]+@[^\\.]+\\..+", message = "Formato Email non valido")
    private String email;

    @Column(name = "username", unique = true, nullable = false)
    @Size(min = 3, max = 30, message = "Username deve contenere un minimo di 3 caratteri ed un massimo di 30")
    @Pattern(regexp = "[\\w]+", message = "Username può contenere lettere maiuscole, underscore e numeri")
    private String username;

    @NotNull
    @Column(name = "password")
    @Size(min = 6, max = 8, message = "La password deve contenere minimo 6 caratteri, massimo 8 caratteri")
    private String password;

    @NotNull
    @Column(name = "conferma_password")
    @Size(min = 6, max = 8)
    private String confermaPassword;

    @NotNull
    @Column(name= "tipo_utenza")
    private String tipoUtenza;

    @NotNull
    @Column(name= "tipo_wallet")
    private String tipoWallet;

    public User() {

    }



}