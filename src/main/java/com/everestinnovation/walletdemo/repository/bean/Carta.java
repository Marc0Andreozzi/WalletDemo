package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Table(name = "carta")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carta")
    private Long idCarta;

    @Column(name = "numero_carta")
    @Pattern(regexp = "([\\d]{4}-){3}[\\d]{4}", message = "Il numero della carta deve essere composto da tre gruppi di quattro cifre separate da trattini.")
    private String numeroCarta;

    @Column(name = "titolare_carta")
    @NotEmpty(message = "Il campo non può essere vuoto!")
    @Pattern(regexp = "[A-Za-z ]{2,40}", message = "Il nome può contenere solo lettere, maiuscole e minuscole, e spazi!")
    private String titolareCarta;

    @Column(name = "scadenza")
    @NotEmpty(message = "Il campo non può essere vuoto!")
    @Pattern(regexp = "(0[1-9]|1[0-2])/[0-9]{2}", message = "Deve essere espressa in MM/YY")
    private String scadenza;

    @Column(name = "cvc_carta")
    @NotEmpty(message = "Il campo non può essere vuoto!")
    @Pattern(regexp = "[\\d]{3}", message = "CVC non valido - Per favore, digitare solo 3 numeri")
    private String cvc;

    @Column(name = "carta_cancellata")
    private boolean cartaCancellata;



}
