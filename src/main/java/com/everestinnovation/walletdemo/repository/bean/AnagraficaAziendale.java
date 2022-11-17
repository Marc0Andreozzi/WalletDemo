package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Data
@Table(name = "anagrafica_az")
public class AnagraficaAziendale {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @Column(name = "denominazione_azienda")
    @Size(min = 3, max = 30)
    private String denominazioneAzienda;

    @Column(name = "natura_giuridica")
    @Size(min = 3, max = 30)
    private String naturaGiuridica; //da inserire? implementazione lista

    @Column(name = "partita_iva")
    @Size(min = 11, max = 30)
    private String pIva;

    @Column(name = "fax")
    @Pattern(regexp = "\\(\\+[0-9]{1,5}\\)[0-9]{3,15}", message = "Formato numero non valido!")
    private int fax;

    @Column(unique = true)
    @Size(min = 10, max = 20)
    private String pec;
}
