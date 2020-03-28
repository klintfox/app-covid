package com.world.meter.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.world.meter.model.Country;

public class GeneralFunctions {

	/**
	 * 
	 * @param urlHtml de la página que contiene una tabla
	 * @return list of countries with
	 */
	public static List<Country> getCountriesCases(String urlHtml) {
		List<Country> lstCountries = new ArrayList<>();
		boolean flag = false;
		int count = 0;
		try {
			Document doc = Jsoup.connect(urlHtml).get();
			Elements tableElements = doc.select("table");
//			Elements tableHeaderEles = tableElements.select("thead tr th");
//			System.out.println("headers");
//			for (int i = 0; i < tableHeaderEles.size(); i++) {
//				System.out.println(tableHeaderEles.get(i).text());
//			}
			Country country;
			Elements tableRowElements = tableElements.select(":not(thead) tr");
			for (int i = 0; i < tableRowElements.size(); i++) {
				Element row = tableRowElements.get(i);
				country = new Country();
				Elements rowItems = row.select("td");
				for (int j = 0; j < rowItems.size(); j++) {
					if (rowItems.get(j).text().equals(Constants.FIRST_COUNTRY)) {
						flag = true;
						count++;
					}
					if (flag && count == 1) {
						if (j == 0) {
							country.setName(rowItems.get(j).text());
						} else if (j == 1) {
							country.setTotalCases(rowItems.get(j).text());
						} else if (j == 2) {
							country.setNewCases(rowItems.get(j).text());
						} else if (j == 3) {
							country.setTotalDeaths(rowItems.get(j).text());
						} else if (j == 4) {
							country.setNewDeaths(rowItems.get(j).text());
						} else if (j == 5) {
							country.setTotalRecovered(rowItems.get(j).text());
						} else if (j == 6) {
							country.setActiveCases(rowItems.get(j).text());
						} else if (j == 7) {
							country.setSeriousCritical(rowItems.get(j).text());
						} else if (j == 8) {
							country.setTotCasesOneMperPop(rowItems.get(j).text());
						} else if (j == 9) {
							country.setTotDeathsOneMperPop(rowItems.get(j).text());
							lstCountries.add(country);
						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lstCountries;
	}

}