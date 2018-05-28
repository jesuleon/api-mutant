package com.mercadolibre.domain;

/**
 * Created by jesus.leon on 27/05/18.
 */
public class StatsResponse {
    private Long countMutantDna;
    private Long countHumanDna;
    private Double ratio;

    public StatsResponse(Long countMutantDna, Long countHumanDna, Double ratio) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        this.ratio = ratio;
    }

    public Long getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(Long countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public Long getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(Long countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
}
