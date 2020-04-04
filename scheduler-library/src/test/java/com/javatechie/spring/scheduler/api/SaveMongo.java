package com.javatechie.spring.scheduler.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.world.meter.model.Country;
import com.world.meter.scheduler.model.Cases;
import com.world.meter.scheduler.utils.OtherFunctions;
import com.world.meter.utils.Constants;
import com.world.meter.utils.GeneralFunctions;

public class SaveMongo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		System.out.println("Inicio: "+new Date());
		List<Country> lstCountries = new ArrayList<>();
		try {
			lstCountries = GeneralFunctions.getCountriesCases(Constants.URLTABLE);
			lstCountries = OtherFunctions.getCountriesWithOutTotals(lstCountries);
			lstCountries.sort(Comparator.comparing(Country::getTotalCases).reversed());
			System.out.println("Tamaño: " +lstCountries.size());
			Date date = new Date();
			for (int i = 0; i < lstCountries.size(); i++) {
				Cases countryCase = new Cases();
//				countryCase.setId(id);
				countryCase.setName(lstCountries.get(i).getName());
				countryCase.setTotalCases(Integer.parseInt(lstCountries.get(i).getTotalCases()));
				countryCase.setNewCases(lstCountries.get(i).getNewCases());
				countryCase.setTotalDeaths(Integer.parseInt(lstCountries.get(i).getTotalDeaths()));
				countryCase.setNewDeaths(Integer.parseInt(lstCountries.get(i).getNewDeaths()));
				countryCase.setTotalRecovered(Integer.parseInt(lstCountries.get(i).getTotalRecovered()));
				countryCase.setActiveCases(Integer.parseInt(lstCountries.get(i).getActiveCases()));
				countryCase.setSeriousCritical(Integer.parseInt(lstCountries.get(i).getSeriousCritical()));
				countryCase.setTotCasesOneMperPop(lstCountries.get(i).getTotCasesOneMperPop());
				countryCase.setTotDeathsOneMperPop(lstCountries.get(i).getTotDeathsOneMperPop());
				countryCase.setReportedFirstCase(lstCountries.get(i).getReportedFirstCase());
				countryCase.setDate(date);
				mongoOperation.save(countryCase, "cases");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin: "+new Date());

	}

}
