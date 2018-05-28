package com.mercadolibre.domain.service;

import com.mercadolibre.domain.StatsResponse;
import com.mercadolibre.domain.model.DnaSequence;
import com.mercadolibre.domain.model.DnaMutantValue;
import org.springframework.stereotype.Service;

/**
 * Created by jesus.leon on 27/05/18.
 */
@Service
public class MutantService {
    /**
     * Posts a mutant
     *
     * @param dnaSequence
     * @return true if dnaSequence is a mutant, false in other case
     */
    public boolean postMutant(DnaSequence dnaSequence) {
        // TODO postear a bd la secuencia
        boolean isMutant = isMutant(dnaSequence.getDna());

        // TODO postear a bd las estadísticas
        return isMutant;
    }

    public StatsResponse stats() {
        Long mutants = 5l;
        Long humans = 10l;
        Double ratio = new Double(mutants / humans);

        return new StatsResponse(mutants, humans, ratio);
    }

    private boolean isMutant(String[] dna) {
        if (dna.length < 4) {
            return false;
        }

        DnaTranspose dnaTranspose = transpose(dna);

        int count = isValidSeq(dnaTranspose.diagonal) ? 1 : 0;

        for (int i = 0; i < dna.length; i++) {
            if (isValidSeq(dna[i])) {
                count++;
            }

            if (count <= 1 && isValidSeq(dnaTranspose.vertical[i])) {
                count++;
            }

            if (count > 1) {
                break;
            }
        }

        return count > 1;
    }

    private boolean isValidSeq(String seq) {
        if (seq.contains(DnaMutantValue.AAAA.name()) ||
                seq.contains(DnaMutantValue.CCCC.name()) ||
                seq.contains(DnaMutantValue.TTTT.name()) |
                        seq.contains(DnaMutantValue.GGGG.name())) {
            return true;
        } else {
            return false;
        }
    }

    private DnaTranspose transpose(String[] dna) {
        String[] result = new String[dna.length];
        StringBuilder diagonal = new StringBuilder("");

        for (int j = 0; j < dna.length; j++) {
            StringBuilder seq = new StringBuilder("");

            for (int i = 0; i < dna.length; i++) {
                seq.append(dna[i].substring(j, j + 1));

                if (i == j) {
                    diagonal.append(dna[i].substring(j, j + 1));
                }
            }

            result[j] = seq.toString();
        }

        return new DnaTranspose(result, diagonal.toString());
    }

    private class DnaTranspose {
        String[] vertical;
        String diagonal;

        public DnaTranspose(String[] vertical, String diagonal) {
            this.vertical = vertical;
            this.diagonal = diagonal;
        }
    }
}
