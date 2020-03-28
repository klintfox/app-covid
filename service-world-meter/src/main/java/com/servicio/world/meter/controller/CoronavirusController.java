package com.servicio.world.meter.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.world.meter.utils.OtherFunctions;
import com.world.meter.model.Country;
import com.world.meter.utils.Constants;
import com.world.meter.utils.GeneralFunctions;

@RestController
@RequestMapping("/api/v1/coronavirus")
public class CoronavirusController {

	private static final Logger logger = LoggerFactory.getLogger(CoronavirusController.class);

	@GetMapping("/countries")
	public List<Country> getCountries() {
		List<Country> lstCountries = new ArrayList<>();
		try {
			lstCountries = GeneralFunctions.getCountriesCases(Constants.URLTABLE);
			lstCountries = OtherFunctions.getCountriesWithOutTotals(lstCountries);
			lstCountries.sort(Comparator.comparing(Country::getTotalCases).reversed());
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return lstCountries;
	}

	@GetMapping("/countries-totals")
	public List<Country> getCountriesWithTotals() {
		List<Country> lstCountries = new ArrayList<>();
		
		Country country = new Country();
		try {
			lstCountries = GeneralFunctions.getCountriesCases(Constants.URLTABLE);
			lstCountries = OtherFunctions.getCountriesWithOutTotals(lstCountries);
			country = OtherFunctions.getTotal(lstCountries);
			lstCountries.sort(Comparator.comparing(Country::getTotalCases).reversed());
			lstCountries.add(country);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return lstCountries;
	}
}
