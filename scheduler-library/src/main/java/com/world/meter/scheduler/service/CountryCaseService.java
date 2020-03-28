package com.world.meter.scheduler.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.world.meter.model.Country;
import com.world.meter.scheduler.model.CountryCase;
import com.world.meter.scheduler.repository.CountryCaseDao;
import com.world.meter.utils.Constants;
import com.world.meter.utils.GeneralFunctions;

@Service
public class CountryCaseService {
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private CountryCaseDao countryDao;

	Logger log = LoggerFactory.getLogger(CountryCaseService.class);

	// schedule a job to add object in DB (Every 10 min)
	@Scheduled(fixedRate = 600000)
	public void add2DBJob() {
		System.out.println("Inicio: "+new Date());
		System.out.println("Ingreso");
		List<Country> lstCountries = new ArrayList<>();
		try {
			lstCountries = GeneralFunctions.getCountriesCases(Constants.URLTABLE);
			lstCountries.remove(lstCountries.size() - 1);
			lstCountries.sort(Comparator.comparing(Country::getTotalCases).reversed());
			System.out.println("Tamaño: " +lstCountries.size());
			Date date = new Date();
			for (int i = 0; i < lstCountries.size(); i++) {
				CountryCase countryCase = new CountryCase();
				countryCase.setId(sequenceGeneratorService.generateSequence(CountryCase.SEQUENCE_NAME));
				countryCase.setName(lstCountries.get(i).getName());
				countryCase.setTotalCases(Integer.parseInt(lstCountries.get(i).getTotalCases()));
				countryCase.setNewCases(lstCountries.get(i).getNewCases());
				countryCase.setTotalDeaths(lstCountries.get(i).getTotalDeaths());
				countryCase.setNewDeaths(lstCountries.get(i).getNewDeaths());
				countryCase.setTotalRecovered(lstCountries.get(i).getTotalRecovered());
				countryCase.setActiveCases(lstCountries.get(i).getActiveCases());
				countryCase.setSeriousCritical(lstCountries.get(i).getSeriousCritical());
				countryCase.setTotCasesOneMperPop(lstCountries.get(i).getTotCasesOneMperPop());
				countryCase.setTotDeathsOneMperPop(lstCountries.get(i).getTotDeathsOneMperPop());
				countryCase.setDate(date);
				countryDao.save(countryCase);
				
			}
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Fin: "+new Date());
	}

//	@Scheduled(cron = "0/15 * * * * *")
//	public void fetchDBJob() {
//		List<User> users = dao.findAll();
//		System.out.println("fetch service call in " + new Date().toString());
//		System.out.println("no of record fetched : " + users.size());
//		log.info("users : {}", users);
//	}

}
