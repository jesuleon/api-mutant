package com.mercadolibre.domain.repository;

import com.mercadolibre.domain.model.DnaSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

/**
 * Created by jesus.leon on 29/05/18.
 */
public interface DnaSequenceRepository extends MongoRepository<DnaSequence, UUID> {
    Long countByMutant(boolean mutant);
}
