package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
public class AnagraficaUtente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int idUser;

    @Column(name = "nome")
    @Size(min = 3, max = 30)
    private String nome;

    @Column(name = "cognome")
    @Size(min = 3, max = 30)
    private String cognome;

    @Column(name = "codice_fiscale")
    @Size(min = 16)
    private String codiceFiscale;

    @Column(name = "indirizzo")
    @Size(min = 20, max = 50)
    private String indirizzo;

    @Column(name = "provincia")
    @Size(min = 2)
    private String provincia;

    @Column(name = "comune")
    @Size(min = 4, max = 10)
    private String comune;

    @Column(name = "cap")
    @Size(min = 5, max = 8 )
    private String cap;

    @Column(name = "paese")
    @Size(min = 5, max = 20)
    private String paese;

    @Column(name = "nato_a")
    @Size(min = 5, max = 30)
    private String natoA;

    @Column(name = "data_di_nascita")
    @Size(min = 8, max = 10)
    private String dataDiNascita;

    @Column(name = "numero di telefono")
    @Pattern(regexp = "\\(\\+[0-9]{1,5}\\)[0-9]{3,15}", message = "Formato numero non valido!")
    private int numeroDiTelefono;
}
