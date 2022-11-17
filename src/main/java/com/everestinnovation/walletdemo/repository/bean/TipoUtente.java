package com.everestinnovation.walletdemo.repository.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class TipoUtente implements Serializable {

    @Id
    @Column(name = "id_tipo_ut", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoUt;


}
