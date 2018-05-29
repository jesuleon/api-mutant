package com.mercadolibre.domain.model;

/**
 * Created by jesus.leon on 29/05/18.
 */
public class Stats {
    private long mutants;
    private long humans;

    public Stats(long mutants, long humans) {
        this.mutants = mutants;
        this.humans = humans;
    }

    public long getMutants() {
        return mutants;
    }

    public long getHumans() {
        return humans;
    }

    public double getRatio() {
        double ratio = humans != 0 ? (double) mutants / (double) humans : (double) mutants;

        return ratio;
    }
}
