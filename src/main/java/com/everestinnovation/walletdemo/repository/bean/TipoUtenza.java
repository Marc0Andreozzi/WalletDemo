package com.everestinnovation.walletdemo.repository.bean;

import java.util.Objects;

public enum TipoUtenza {

    PERSONALE(1, "Personale"),
    AZIENDALE(2, "Aziendale");

    private final int id;

    private final String tipo;


    TipoUtenza(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public static TipoUtenza ofId(int id){
        for(TipoUtenza value : TipoUtenza.values()){
            if(id == value.id){
                return value;
            }
        }
        throw new EnumConstantNotPresentException(TipoUtenza.class, String.valueOf(id));
    }

    public static TipoUtenza ofTipo(String tipo){
        for(TipoUtenza value : TipoUtenza.values()){
            if (Objects.equals(tipo, value.tipo)){
                return value;
            }
        }
        throw new EnumConstantNotPresentException(TipoUtenza.class, String.valueOf(tipo));
    }


}
