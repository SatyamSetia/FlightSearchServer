package com.nagarro.flightsearchserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency_table")
public class Currency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "country_name", unique = true, nullable = false, length = 1000)
	private String countryName;
	
	@Column(name = "country_code", unique = true, nullable = false, length = 1000)
	private String countryCode;
	
	@Column(name = "conversion_rate", unique = true, nullable = false, length = 1000)
	private float conversionRate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public float getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(float conversionRate) {
		this.conversionRate = conversionRate;
	}

}
