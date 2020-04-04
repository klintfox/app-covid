package com.world.meter.scheduler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.world.meter.scheduler.model.Cases;

@Repository
public interface CasesRepository extends MongoRepository<Cases, Long>{

}
