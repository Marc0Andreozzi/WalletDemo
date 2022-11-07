package com.everestinnovation.walletdemo.repository.bean;

import java.util.Objects;

public enum TipoWallet {
    PRIVATO(1, "Privato"),
    MULTI_SIG(2, "Multi_sig");

    private final int id;

    private final String tipoWallet;

    TipoWallet(int id, String tipoWallet) {
        this.id = id;
        this.tipoWallet = tipoWallet;
    }

    public static TipoWallet idWallet(int id){
        for(TipoWallet value : TipoWallet.values()){
            if(id == value.id){
                return value;
            }
        }
        throw new EnumConstantNotPresentException(TipoWallet.class, String.valueOf(id));
    }

    public static TipoWallet tipoWallet(String tipoWallet){
        for (TipoWallet value : TipoWallet.values()){
            if (Objects.equals(tipoWallet, value.tipoWallet)){
                return value;
            }
        }
        throw new EnumConstantNotPresentException(TipoWallet.class, String.valueOf(tipoWallet));

    }
}

