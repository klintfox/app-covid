package com.world.meter.scheduler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.world.meter.scheduler.model.CountryCase;

public interface CountryCaseDao extends  MongoRepository<CountryCase, Long>{

}
