package com.world.meter.scheduler.model;

import java.util.Date;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "countrycase")
public class Cases {

	@Transient
	public static final String SEQUENCE_NAME = "coronavirus_sequence";

//	@Id
//	private long id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("totalCases")
	private Integer totalCases;
	
	@JsonProperty("newCases")
	private String newCases;
	
	@JsonProperty("totalDeaths")
	private Integer totalDeaths;
	
	@JsonProperty("newDeaths")
	private Integer newDeaths;
	
	@JsonProperty("totalRecovered")
	private Integer totalRecovered;
	
	@JsonProperty("activeCases")
	private Integer activeCases;
	
	@JsonProperty("seriousCritical")
	private Integer seriousCritical;
	
	@JsonProperty("totCasesOneMperPop")
	private String totCasesOneMperPop;
	
	@JsonProperty("totDeathsOneMperPop")
	private String totDeathsOneMperPop;
	
	@JsonProperty("reportedFirstCase")
	private String reportedFirstCase;
	
	@JsonProperty("date")
	private Date date;

	public Cases() {
	}

//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public Integer getTotalCases() {
		return totalCases;
	}

	public String getNewCases() {
		return newCases;
	}

	public Integer getTotalDeaths() {
		return totalDeaths;
	}

	public Integer getNewDeaths() {
		return newDeaths;
	}

	public Integer getTotalRecovered() {
		return totalRecovered;
	}

	public Integer getActiveCases() {
		return activeCases;
	}

	public Integer getSeriousCritical() {
		return seriousCritical;
	}

	public String getTotCasesOneMperPop() {
		return totCasesOneMperPop;
	}

	public Date getDate() {
		return date;
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

	public void setTotalDeaths(Integer totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public void setNewDeaths(Integer newDeaths) {
		this.newDeaths = newDeaths;
	}

	public void setTotalRecovered(Integer totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public void setActiveCases(Integer activeCases) {
		this.activeCases = activeCases;
	}

	public void setSeriousCritical(Integer seriousCritical) {
		this.seriousCritical = seriousCritical;
	}

	public void setTotCasesOneMperPop(String totCasesOneMperPop) {
		this.totCasesOneMperPop = totCasesOneMperPop;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTotDeathsOneMperPop() {
		return totDeathsOneMperPop;
	}

	public void setTotDeathsOneMperPop(String totDeathsOneMperPop) {
		this.totDeathsOneMperPop = totDeathsOneMperPop;
	}

	public String getReportedFirstCase() {
		return reportedFirstCase;
	}

	public void setReportedFirstCase(String reportedFirstCase) {
		this.reportedFirstCase = reportedFirstCase;
	}
	
	

}