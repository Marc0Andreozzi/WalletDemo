package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "anagrafica_aziendale")
public class AnagraficaAziendale {

        @Id
        @Column(name = "id", unique = true, nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private int idUser;

        @Column(name = "denominazione_azienda")
        @Size(min = 3, max = 30)
        private String denominazioneAzienda;

        @Column(name = "natura_giuridica")
        @Size(min = 3, max = 30)
        private String naturaGiuridica; //da inserire? implementazione lista

        @Column(name = "codice_fiscale")
        @Size(min = 8, max = 10)
        private String codiceFiscale;

        @Column(name = "partita_iva")
        @Size(min = 11, max = 30)
        private String pIva;

        @Column(name = "regione")
        @Size(min = 3, max = 30)
        private String regione;

        @Column(name = "provincia")
        @Size(min = 3, max = 30)
        private String provincia;

        @Column(name = "comune")
        @Size(min = 3, max = 30)
        private String comune;

        @Column(name = "cap")
        @Size(min = 5, max = 30)
        private int cap;

        @Column(name = "indirizzo")
        @Size(min = 10, max = 50)
        private String indirizzo;

        @Column(name = "telefono")
        @Pattern(regexp = "\\(\\+[0-9]{1,5}\\)[0-9]{3,15}", message = "Formato numero non valido!")
        private int telefono;

        @Column(name = "fax")
        @Pattern(regexp = "\\(\\+[0-9]{1,5}\\)[0-9]{3,15}", message = "Formato numero non valido!")
        private int fax;

        @Column(unique = true)
        @Size(min = 10, max = 20)
        private String pec;

}


