package com.mercadolibre;

import com.mercadolibre.domain.service.DnaService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jesus.leon on 29/05/18.
 */
public class BasicTest {
    protected String[] MUTANT_DNA = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
    protected String[] HUMAN_DNA = new String[] { "TTGCAA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

    @Autowired
    protected DnaService dnaService;

    @Before
    public void cleanData() {
        dnaService.deleteAll();
    }
}
