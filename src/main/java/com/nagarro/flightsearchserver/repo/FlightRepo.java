package com.nagarro.flightsearchserver.repo;

import java.util.List;

import com.nagarro.flightsearchserver.dto.FlightSearchDetails;
import com.nagarro.flightsearchserver.dto.OutputFlight;

public interface FlightRepo {
	
	/**
	 * @param searchDetails
	 * @param countryCode
	 * @return List of flights
	 * @description Repository to get list of all direct flights from database. 
	 */
	List<OutputFlight> getAllDirectFlights(FlightSearchDetails searchDetails, String countryCode);
	
	/**
	 * @param searchDetails
	 * @param countryCode
	 * @return List of flights
	 * @description Repository to get list of all connected flights from database. 
	 */
	List<OutputFlight> getAllConnectedFlights(FlightSearchDetails searchDetails, String countryCode);
}
