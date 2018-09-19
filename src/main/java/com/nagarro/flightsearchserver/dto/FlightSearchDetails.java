package com.nagarro.flightsearchserver.dto;

/**
 * @author satyamsetia
 * @description DTO for handling user inputs.
 */
public class FlightSearchDetails {

	private String departure;
	private String arrival;
	private String travelDate;
	private String travelClass;
	private String sortPreference;
	private int pageNo;

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	
	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	
	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	
	public String getSortPreference() {
		return sortPreference;
	}

	public void setSortPreference(String sortPreference) {
		this.sortPreference = sortPreference;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
