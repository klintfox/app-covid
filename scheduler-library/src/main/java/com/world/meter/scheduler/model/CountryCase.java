package com.world.meter.scheduler.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "countrycase")
public class CountryCase {

	@Transient
    public static final String SEQUENCE_NAME = "coronavirus_sequence";

	@Id
	private long id;
	
	private String name;
	private Integer totalCases;
	private String newCases;
	private String totalDeaths;
	private String newDeaths;
	private String totalRecovered;
	private String activeCases;
	private String seriousCritical;
	private String totCasesOneMperPop;
	private String totDeathsOneMperPop;
	private Date date;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getTotalCases() {
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
	public Date getDate() {
		return date;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTotalCases(Integer totalCases) {
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
	public void setDate(Date date) {
		this.date = date;
	}

}