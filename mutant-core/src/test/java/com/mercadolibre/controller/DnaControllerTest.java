package com.mercadolibre.controller;

import com.mercadolibre.domain.DnaRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jesus.leon on 27/05/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DnaControllerTest extends ControllerTest {
    @Test
    public void postMutantWithNxM() throws Exception {
        String[] dna = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA" };

        DnaRequest dnaRequest = new DnaRequest(dna);

        String content = json(dnaRequest);

        mvc.perform(MockMvcRequestBuilders.post("/")
                .content(content)
                .contentType(contentType)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    public void postMutantWithInvalidLetter() throws Exception {
        String[] dna = new String[] { "ATGCGA", "CAGTGC", "TTABGT", "AGAAGG", "CCCCTA" , "AAATTT"};

        DnaRequest dnaRequest = new DnaRequest(dna);

        String content = json(dnaRequest);

        mvc.perform(MockMvcRequestBuilders.post("/")
                .content(content)
                .contentType(contentType)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    public void postMutantWithRequestNull() throws Exception {
        String content = json(null);

        mvc.perform(MockMvcRequestBuilders.post("/")
                .content(content)
                .contentType(contentType)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    public void postMutantWithRequestEmpty() throws Exception {
        String content = json(new DnaRequest(null));

        mvc.perform(MockMvcRequestBuilders.post("/")
                .content(content)
                .contentType(contentType)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    public void stats() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/stats")
                .contentType(contentType)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        ;
    }
}