package com.mercadolibre.service;

import com.mercadolibre.BasicTest;
import com.mercadolibre.domain.model.Stats;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jesus.leon on 27/05/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DnaServiceTest extends BasicTest {
    @Test
    public void postMutantThenItIsMutant() {
        Assert.assertEquals(true, dnaService.postDna(MUTANT_DNA).isMutant());
    }

    @Test
    public void postMutantThenItIsNotAMutant() {
        Assert.assertEquals(false, dnaService.postDna(HUMAN_DNA).isMutant());
    }

    @Test
    public void postMutantWithNxNWithNLessToFour() {
        String[] dna = new String[] { "ATG", "CAG", "TTA" };

        Assert.assertEquals(false, dnaService.postDna(dna).isMutant());
    }

    @Test
    public void statsWithoutDna() {
        Stats stats = dnaService.stats();
        Assert.assertEquals(0.0, stats.getRatio(), 0.0000001);
    }

    @Test
    public void statsWithOnlyHumans() {
        dnaService.postDna(HUMAN_DNA);
        dnaService.postDna(HUMAN_DNA);
        dnaService.postDna(HUMAN_DNA);
        Stats stats = dnaService.stats();

        Assert.assertEquals(0.0, stats.getRatio(), 0.000001);
    }

    @Test
    public void statsWithOnlyMutants() {
        dnaService.postDna(MUTANT_DNA);
        dnaService.postDna(MUTANT_DNA);
        dnaService.postDna(MUTANT_DNA);

        Assert.assertEquals(3.0, dnaService.stats().getRatio(), 0.000001);
    }

    @Test
    public void stats() {
        dnaService.postDna(MUTANT_DNA);
        dnaService.postDna(HUMAN_DNA);
        dnaService.postDna(HUMAN_DNA);

        Stats stats = dnaService.stats();

        Assert.assertEquals(0.5, stats.getRatio(), 0.000001);
    }
}
