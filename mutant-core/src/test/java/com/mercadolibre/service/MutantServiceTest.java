package com.mercadolibre.service;

import com.mercadolibre.domain.model.DnaSequence;
import com.mercadolibre.domain.service.MutantService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jesus.leon on 27/05/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MutantServiceTest {
    @Autowired
    private MutantService mutantService;

    @Test
    public void postMutantThenItIsMutant() {
        String[] dna = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
        DnaSequence dnaSequence = new DnaSequence();
        dnaSequence.setDna(dna);

        Assert.assertEquals(true, mutantService.postMutant(dnaSequence));
    }

    @Test
    public void postMutantThenItIsNotAMutant() {
        String[] dna = new String[] { "TTGCAA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG" };
        DnaSequence dnaSequence = new DnaSequence();
        dnaSequence.setDna(dna);

        Assert.assertEquals(false, mutantService.postMutant(dnaSequence));
    }

    @Test
    public void postMutantWithNxNWithNLessToFour() {
        String[] dna = new String[] { "ATG", "CAG", "TTA" };
        DnaSequence dnaSequence = new DnaSequence();
        dnaSequence.setDna(dna);

        Assert.assertEquals(false, mutantService.postMutant(dnaSequence));
    }
}
