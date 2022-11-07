package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AnagraficaAziendale {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private int idUser;

        private String denominazioneAzienda;
        private String naturaGiuridica; //da inserire? implementazione lista
        private String codiceFiscale;
        private String pIva;
        private String regione;
        private String provincia;
        private String comune;
        private int cap;
        private String indirizzo;
        private int telefono;
        private int fax;

        @Column(unique = true)
        private String pec;

}


