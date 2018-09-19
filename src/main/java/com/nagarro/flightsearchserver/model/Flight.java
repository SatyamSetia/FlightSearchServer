package com.nagarro.flightsearchserver.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights_table")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "flight_no", unique = true, nullable = false, length = 1000)
	private String flightNo;
	
	@Column(name = "departure_loc", unique = true, nullable = false, length = 1000)
	private String departureLoc;
	
	@Column(name = "arrival_loc", unique = true, nullable = false, length = 1000)
	private String arrivalLoc;
	
	@Column(name = "valid_till", unique = true, nullable = false, length = 1000)
	private LocalDate validTill;
	
	@Column(name = "flight_dep_time", unique = true, nullable = false, length = 1000)
	private LocalTime flightDepTime;
	
	@Column(name = "flight_arr_time", unique = true, nullable = false, length = 1000)
	private LocalTime flightArrTime;
	
	@Column(name = "fare", unique = true, nullable = false, length = 1000)
	private Float fare;
	
	@Column(name = "seat_availability", unique = true, nullable = false, length = 1000)
	private String seatAvailability;
	
	@Column(name = "travel_class", unique = true, nullable = false, length = 1000)
	private String travelClass;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepartureLoc() {
		return departureLoc;
	}
	public void setDepartureLoc(String departureLoc) {
		this.departureLoc = departureLoc;
	}
	public String getArrivalLoc() {
		return arrivalLoc;
	}
	public void setArrivalLoc(String arrivalLoc) {
		this.arrivalLoc = arrivalLoc;
	}
	public LocalDate getValidTill() {
		return validTill;
	}
	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}
	public LocalTime getFlightDepTime() {
		return flightDepTime;
	}
	public void setFlightDepTime(LocalTime flightDepTime) {
		this.flightDepTime = flightDepTime;
	}
	public LocalTime getFlightArrTime() {
		return flightArrTime;
	}
	public void setFlightArrTime(LocalTime flightArrTime) {
		this.flightArrTime = flightArrTime;
	}
	public Float getFare() {
		return fare;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	public String getSeatAvailability() {
		return seatAvailability;
	}
	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}
	public String getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	
	public String toString() {
		return this.flightNo+": "+this.departureLoc+" to "+this.arrivalLoc;
	}
}
