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
	 * Give information from table of cases of coronavirus by WorldMeter
	 * @param urlHtml is the page the have the information
	 * @return List<Country>
	 */
	public static List<Country> getCountriesCases(String urlHtml) {
		List<Country> lstCountries = new ArrayList<>();
		boolean flag = false;
		int count = 0;
		try {
			Document doc = Jsoup.connect(urlHtml).get();
			Elements tableElements = doc.select("table");
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
							country.setTotalCases(replaceComas(rowItems.get(j).text()));
						} else if (j == 2) {
							country.setNewCases(replaceComas(rowItems.get(j).text()));
						} else if (j == 3) {
							country.setTotalDeaths(replaceComas(rowItems.get(j).text()));
						} else if (j == 4) {
							country.setNewDeaths(replaceComas(rowItems.get(j).text()));
						} else if (j == 5) {
							country.setTotalRecovered(replaceComas(rowItems.get(j).text()));
						} else if (j == 6) {
							country.setActiveCases(replaceComas(rowItems.get(j).text()));
						} else if (j == 7) {
							country.setSeriousCritical(replaceComas(rowItems.get(j).text()));
						} else if (j == 8) {
							country.setTotCasesOneMperPop(replaceComas(rowItems.get(j).text()));
						} else if (j == 9) {
							country.setTotDeathsOneMperPop(replaceComas(rowItems.get(j).text()));
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

	public static String replaceComas(String text) {
		String result = "0";
		if (!text.isEmpty()) {
			result = text.replace(",", "");
		}
		return result;
	}

}