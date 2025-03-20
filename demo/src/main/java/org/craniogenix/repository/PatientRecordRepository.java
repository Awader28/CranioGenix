package org.craniogenix.repository;

import org.craniogenix.model.PatientRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface PatientRecordRepository extends MongoRepository<PatientRecord, String> {
    Optional<PatientRecord> findByName(String name);
    void deleteByName(String name);
}
