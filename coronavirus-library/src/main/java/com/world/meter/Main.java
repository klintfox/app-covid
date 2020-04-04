package com.world.meter;

/*
 * @author      Klint Román
 * @version     1.0
 * @since       2020-03-27
 *
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.world.meter.model.Country;
import com.world.meter.utils.Constants;
import com.world.meter.utils.GeneralFunctions;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println(new Date());
		try {
			List<Country> lstCountries = new ArrayList<>();
			lstCountries = GeneralFunctions.getCountriesCases(Constants.URLTABLE);
			for (int i = 0; i < lstCountries.size(); i++) {
				System.out.println(
						i + 1 + ": " + lstCountries.get(i).getName() + " " + lstCountries.get(i).getTotalCases());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(new Date());
	}
}