package com.world.meter.model;

public class Country {

	private String name;
	private String totalCases;
	private String newCases;
	private String totalDeaths;
	private String newDeaths;
	private String totalRecovered;
	private String activeCases;
	private String seriousCritical;
	private String totCasesOneMperPop;
	private String totDeathsOneMperPop;
	private String reportedFirstCase;

	public Country() {
	}

	public Country(String name, String totalCases, String newCases, String totalDeaths, String newDeaths,
			String totalRecovered, String activeCases, String seriousCritical, String totCasesOneMperPop,
			String totDeathsOneMperPop, String reportedFirstCase) {
		super();
		this.name = name;
		this.totalCases = totalCases;
		this.newCases = newCases;
		this.totalDeaths = totalDeaths;
		this.newDeaths = newDeaths;
		this.totalRecovered = totalRecovered;
		this.activeCases = activeCases;
		this.seriousCritical = seriousCritical;
		this.totCasesOneMperPop = totCasesOneMperPop;
		this.totDeathsOneMperPop = totDeathsOneMperPop;
		this.reportedFirstCase = reportedFirstCase;
	}

	public String getName() {
		return name;
	}

	public String getTotalCases() {
		return totalCases;
	}

	public String getNewCases() {
		return newCases;
	}

	public String getTotalDeaths() {
		return totalDeaths;
	}

	public String getNewDeaths() {
		return newDeaths;
	}

	public String getTotalRecovered() {
		return totalRecovered;
	}

	public String getActiveCases() {
		return activeCases;
	}

	public String getSeriousCritical() {
		return seriousCritical;
	}

	public String getTotCasesOneMperPop() {
		return totCasesOneMperPop;
	}

	public String getTotDeathsOneMperPop() {
		return totDeathsOneMperPop;
	}

	public String getReportedFirstCase() {
		return reportedFirstCase;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}

	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}

	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}

	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public void setActiveCases(String activeCases) {
		this.activeCases = activeCases;
	}

	public void setSeriousCritical(String seriousCritical) {
		this.seriousCritical = seriousCritical;
	}

	public void setTotCasesOneMperPop(String totCasesOneMperPop) {
		this.totCasesOneMperPop = totCasesOneMperPop;
	}

	public void setTotDeathsOneMperPop(String totDeathsOneMperPop) {
		this.totDeathsOneMperPop = totDeathsOneMperPop;
	}

	public void setReportedFirstCase(String reportedFirstCase) {
		this.reportedFirstCase = reportedFirstCase;
	}

}