package com.mercadolibre.controller;

import com.mercadolibre.domain.DnaRequest;
import com.mercadolibre.domain.StatsResponse;
import com.mercadolibre.domain.model.DnaSequence;
import com.mercadolibre.domain.service.MutantService;
import com.mercadolibre.validator.DnaInRange;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * Created by jesus.leon on 13/05/18.
 */
@RestController("/")
@Validated
public class MutantController {
    private final MutantService mutantService;

    @Autowired
    public MutantController(MutantService mutantService) {
        this.mutantService = mutantService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> postMutant(
            @Valid @DnaInRange @RequestBody DnaRequest dnaRequest) {
        if (mutantService.postMutant(transform(dnaRequest))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> stats() {
        return ResponseEntity.ok(mutantService.stats());
    }

    private DnaSequence transform(DnaRequest dnaRequest) {
        DnaSequence dnaSequence = new DnaSequence();

        BeanUtils.copyProperties(dnaRequest, dnaSequence);

        return dnaSequence;
    }
}
