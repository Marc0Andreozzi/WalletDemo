package com.everestinnovation.walletdemo.repository.enums;

import java.util.Objects;

public enum TipoTransazione {

    IN_ENTRATA(1, "In Entrata"),
    IN_USCITA(2,"In Uscita"),
    TRASFERIMENTO_A(3, "Trasferimento a"),
    TRASFERIMENTO_DA(4, "Trasferimetno da");

    private final int idOp;

    private final String tipoOp;

    TipoTransazione(int idOp, String tipoOp) {
        this.idOp = idOp;
        this.tipoOp = tipoOp;
    }

    public static TipoTransazione ofIdOp(int idOp){
        for(TipoTransazione value : TipoTransazione.values()){
            if(idOp == value.idOp){
                return value;
            }
        }
        throw new EnumConstantNotPresentException(TipoUtenza.class, String.valueOf(idOp));
    }

    public static TipoTransazione ofTipoOp(String tipoOp){
        for(TipoTransazione value : TipoTransazione.values()){
            if (Objects.equals(tipoOp, value.tipoOp)){
                return value;
            }
        }
        throw new EnumConstantNotPresentException(TipoUtenza.class, String.valueOf(tipoOp));
    }

}

