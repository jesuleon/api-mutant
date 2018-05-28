package com.mercadolibre.domain;

import java.io.Serializable;

/**
 * Created by jesus.leon on 13/05/18.
 */
public class DnaRequest implements Serializable {
    private String[] dna;

    private DnaRequest() {
    }

    public DnaRequest(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
