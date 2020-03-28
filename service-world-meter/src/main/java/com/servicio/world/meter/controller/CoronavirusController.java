package com.servicio.world.meter.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			lstCountries.remove(lstCountries.size() - 1);
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

			// get last object
			country.setName(lstCountries.get(lstCountries.size() - 1).getName());
			country.setTotalCases(lstCountries.get(lstCountries.size() - 1).getTotalCases());
			country.setNewCases(lstCountries.get(lstCountries.size() - 1).getNewCases());
			country.setTotalDeaths(lstCountries.get(lstCountries.size() - 1).getTotalDeaths());
			country.setNewDeaths(lstCountries.get(lstCountries.size() - 1).getNewDeaths());
			country.setTotalRecovered(lstCountries.get(lstCountries.size() - 1).getTotalRecovered());
			country.setActiveCases(lstCountries.get(lstCountries.size() - 1).getActiveCases());
			country.setSeriousCritical(lstCountries.get(lstCountries.size() - 1).getSeriousCritical());
			country.setTotCasesOneMperPop(lstCountries.get(lstCountries.size() - 1).getTotCasesOneMperPop());
			country.setTotDeathsOneMperPop(lstCountries.get(lstCountries.size() - 1).getTotDeathsOneMperPop());

			lstCountries.remove(lstCountries.size() - 1);
			lstCountries.sort(Comparator.comparing(Country::getTotalCases).reversed());

			// add last object to list
			lstCountries.add(country);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return lstCountries;

	}
}
