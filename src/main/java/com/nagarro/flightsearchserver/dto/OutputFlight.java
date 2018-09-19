package com.nagarro.flightsearchserver.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author satyamsetia
 * @description DTO for handling response object.
 */
public class OutputFlight {
	
	private boolean isConnected;
	
	private String departure;
	
	private String arrival;
	
	private String stop;
	
	private String flightNoOne;
	
	private String flightNoTwo;
	
	private LocalTime flightDuration;
	
	private LocalTime flightDepTimeOne;
	
	private LocalTime flightArrTimeOne;
	
	private LocalTime flightDepTimeTwo;
	
	private LocalTime flightArrTimeTwo;
	
	private LocalDate travelDate;
	
	private Float fare;
	
	private String travelClass;

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

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

	public String getStop() {
		return stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	public String getFlightNoOne() {
		return flightNoOne;
	}

	public void setFlightNoOne(String flightNoOne) {
		this.flightNoOne = flightNoOne;
	}

	public String getFlightNoTwo() {
		return flightNoTwo;
	}

	public void setFlightNoTwo(String flightNoTwo) {
		this.flightNoTwo = flightNoTwo;
	}

	public LocalTime getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(LocalTime flightDuration) {
		this.flightDuration = flightDuration;
	}

	public LocalTime getFlightDepTimeOne() {
		return flightDepTimeOne;
	}

	public void setFlightDepTimeOne(LocalTime flightDepTimeOne) {
		this.flightDepTimeOne = flightDepTimeOne;
	}

	public LocalTime getFlightArrTimeOne() {
		return flightArrTimeOne;
	}

	public void setFlightArrTimeOne(LocalTime flightArrTimeOne) {
		this.flightArrTimeOne = flightArrTimeOne;
	}

	public LocalTime getFlightDepTimeTwo() {
		return flightDepTimeTwo;
	}

	public void setFlightDepTimeTwo(LocalTime flightDepTimeTwo) {
		this.flightDepTimeTwo = flightDepTimeTwo;
	}

	public LocalTime getFlightArrTimeTwo() {
		return flightArrTimeTwo;
	}

	public void setFlightArrTimeTwo(LocalTime flightArrTimeTwo) {
		this.flightArrTimeTwo = flightArrTimeTwo;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public Float getFare() {
		return fare;
	}

	public void setFare(Float fare) {
		this.fare = fare;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	
}
