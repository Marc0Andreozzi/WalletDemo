package com.everestinnovation.walletdemo.repository.enums;

import java.util.Objects;

public enum TipoUtente {

    PERSONALE(1, "Personale"),
    AZIENDALE(2, "Aziendale");

    private final int idTipoUt;

    private final String tipo;


    TipoUtente(int id, String tipo) {
        this.idTipoUt = id;
        this.tipo = tipo;
    }

    public static TipoUtente ofId(int id){
        for(TipoUtente value : TipoUtente.values()){
            if(id == value.idTipoUt){
                return value;
            }
        }
        throw new EnumConstantNotPresentException(TipoUtente.class, String.valueOf(id));
    }

    public static TipoUtente ofTipo(String tipo){
        for(TipoUtente value : TipoUtente.values()){
            if (Objects.equals(tipo, value.tipo)){
                return value;
            }
        }
        throw new EnumConstantNotPresentException(TipoUtente.class, String.valueOf(tipo));
    }


}
