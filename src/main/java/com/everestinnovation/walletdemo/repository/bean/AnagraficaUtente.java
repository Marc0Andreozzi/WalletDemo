package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class AnagraficaUtente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int idUser;

    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String indirizzo;
    private String provincia;
    private String comune;
    private String cap;
    private String paese;
    private String natoA;
    private String dataDiNascita;
    private int numeroDiTelefono;
}
