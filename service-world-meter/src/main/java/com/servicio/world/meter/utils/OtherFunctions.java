package com.servicio.world.meter.utils;

import java.util.List;

import com.world.meter.model.Country;
import com.world.meter.utils.Constants;

public class OtherFunctions {

	public static List<Country> getCountriesWithOutTotals(List<Country> lstCountries) {
		for (int i = 0; i < lstCountries.size(); i++) {
			if (lstCountries.get(i).toString().equals(Constants.TOTAL)) {
				lstCountries.remove(i);
				break;
			}
		}
		return lstCountries;
	}

	@SuppressWarnings("unused")
	public static Country getTotal(List<Country> lstCountries) {
		Country country = null;
		try {
			for (int i = 0; i < lstCountries.size(); i++) {
				if (lstCountries.get(i).getName().equals(Constants.TOTAL)) {
					country = new Country();
					country.setName(lstCountries.get(i).getName());
					country.setTotalCases(lstCountries.get(i).getTotalCases());
					country.setNewCases(lstCountries.get(i).getNewCases());
					country.setTotalDeaths(lstCountries.get(i).getTotalDeaths());
					country.setNewDeaths(lstCountries.get(i).getNewDeaths());
					country.setTotalRecovered(lstCountries.get(i).getTotalRecovered());
					country.setActiveCases(lstCountries.get(i).getActiveCases());
					country.setSeriousCritical(lstCountries.get(i).getSeriousCritical());
					country.setTotCasesOneMperPop(lstCountries.get(i).getTotCasesOneMperPop());
					country.setTotDeathsOneMperPop(lstCountries.get(i).getTotDeathsOneMperPop());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return country;
	}
}
