package com.world.meter.scheduler.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.world.meter.model.Country;
import com.world.meter.scheduler.model.Cases;
import com.world.meter.scheduler.utils.GeneralConstants;
import com.world.meter.scheduler.utils.OtherFunctions;
import com.world.meter.utils.Constants;
import com.world.meter.utils.GeneralFunctions;

@Service
public class CasesService {
	
	Logger log = LoggerFactory.getLogger(CasesService.class);

	@SuppressWarnings("resource")
	@Scheduled(fixedRate = GeneralConstants.TIEMPO_SCHEDULER)
	public void execute() {
		
		String uriconnection = GeneralConstants.URI_PROD_CONNECTION;
		MongoClientURI uri = new MongoClientURI(uriconnection);
		MongoClient mongo_client = new MongoClient(uri);
		MongoDatabase db = mongo_client.getDatabase("coronavirus");
		MongoCollection<Document> coll = db.getCollection("cases");

		System.out.println("Inicio: " + new Date());
		List<Country> lstCountries = new ArrayList<>();
		try {
			lstCountries = GeneralFunctions.getCountriesCases(Constants.URLTABLE);
			lstCountries = OtherFunctions.getCountriesWithOutTotals(lstCountries);
			lstCountries.sort(Comparator.comparing(Country::getTotalCases).reversed());
			Date date = new Date();
			for (int i = 0; i < lstCountries.size(); i++) {
				Cases countryCase = new Cases();
				countryCase.setName(lstCountries.get(i).getName());
				countryCase.setTotalCases(Integer.parseInt(lstCountries.get(i).getTotalCases()));
				countryCase.setNewCases(lstCountries.get(i).getNewCases());
				countryCase.setTotalDeaths(Integer.parseInt(lstCountries.get(i).getTotalDeaths()));
				countryCase.setNewDeaths(lstCountries.get(i).getNewDeaths());
				countryCase.setTotalRecovered(Integer.parseInt(lstCountries.get(i).getTotalRecovered()));
				countryCase.setActiveCases(Integer.parseInt(lstCountries.get(i).getActiveCases()));
				countryCase.setSeriousCritical(Integer.parseInt(lstCountries.get(i).getSeriousCritical()));
				countryCase.setTotCasesOneMperPop(lstCountries.get(i).getTotCasesOneMperPop());
				countryCase.setTotDeathsOneMperPop(lstCountries.get(i).getTotDeathsOneMperPop());
				countryCase.setDate(date);
				Gson gson = new Gson();
				Document document = Document.parse(gson.toJson(countryCase));
				coll.insertOne(document);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error:"+e.getMessage());
		}
		System.out.println("Fin: " + new Date());
	}

}