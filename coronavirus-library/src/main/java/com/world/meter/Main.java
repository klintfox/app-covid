package com.world.meter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.world.meter.model.Country;
import com.world.meter.utils.Constants;
import com.world.meter.utils.GeneralFunctions;

public class Main {

	public static void main(String[] args) throws IOException {

		try {
			List<Country> lstCountries = new ArrayList<>();
			lstCountries = GeneralFunctions.getCountriesCases(Constants.URLTABLE);
			lstCountries.sort(Comparator.comparing(Country::getTotalCases).reversed());
			System.out.println(new Date());
			for (int i = 0; i < lstCountries.size(); i++) {
				System.out.println(i + 1 + ": " + lstCountries.get(i).getName() + " " + lstCountries.get(i).getTotalCases());
			}
			System.out.println(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}