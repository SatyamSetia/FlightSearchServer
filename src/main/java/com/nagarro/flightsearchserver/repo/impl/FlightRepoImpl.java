package com.nagarro.flightsearchserver.repo.impl;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.flightsearchserver.constants.HqlQueries;
import com.nagarro.flightsearchserver.constants.Keys;
import com.nagarro.flightsearchserver.dto.FlightSearchDetails;
import com.nagarro.flightsearchserver.dto.OutputFlight;
import com.nagarro.flightsearchserver.model.Flight;
import com.nagarro.flightsearchserver.repo.FlightRepo;
import com.nagarro.flightsearchserver.utils.ConvertToOutputFlight;
import com.nagarro.flightsearchserver.utils.HibernateUtils;

public class FlightRepoImpl implements FlightRepo {
	
	private Session session;
	
	public FlightRepoImpl() {
		this.session = HibernateUtils.createSession();
	}

	@Override
	public List<OutputFlight> getAllDirectFlights(FlightSearchDetails searchDetails, String countryCode) {
		
		String hqlQuery = null;
		
		if(searchDetails.getSortPreference().equals("Fastest")) {
			hqlQuery = HqlQueries.SELECT_DIRECT_FLIGHTS_FROM_TABLE_SORT_BY_DUR;
		} else if(searchDetails.getSortPreference().equals("Cheapest")) {
			hqlQuery = HqlQueries.SELECT_DIRECT_FLIGHTS_FROM_TABLE_SORT_BY_FARE;
		}
		
		Query<Flight> query = this.session.createQuery(hqlQuery);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(searchDetails.getTravelDate(),dtf);
		
		query.setParameter("departure", searchDetails.getDeparture());
		query.setParameter("arrival", searchDetails.getArrival());
		query.setParameter("travelDate", date);
		query.setParameter("travelClass", "%"+searchDetails.getTravelClass()+"%"); 
		query.setFirstResult((searchDetails.getPageNo()-1)*Keys.MAX_NUMBER_OF_FLIGHTS_ON_ONE_PAGE);
		query.setMaxResults(Keys.MAX_NUMBER_OF_FLIGHTS_ON_ONE_PAGE);
		
		List<Flight> resultList = query.getResultList();
		
		List<OutputFlight> flights = new ArrayList<>();
		
		float conversionRate = getConversionRate(countryCode);
		
		for(Flight flight: resultList) {
			OutputFlight ithFlight = ConvertToOutputFlight.convert(flight);
			ithFlight.setFare(ithFlight.getFare() * conversionRate);
			flights.add(ithFlight);
		}
		
		return flights;
	}
	
	public List<OutputFlight> getAllConnectedFlights(FlightSearchDetails searchDetails, String countryCode) {
		
		String hqlQuery = null;
		
		if(searchDetails.getSortPreference().equals("Fastest")) {
			hqlQuery = HqlQueries.SELECT_CONNECTED_FLIGHTS_FROM_TABLE_SORT_BY_DUR;
		} else if(searchDetails.getSortPreference().equals("Cheapest")) {
			hqlQuery = HqlQueries.SELECT_CONNECTED_FLIGHTS_FROM_TABLE_SORT_BY_FARE;
		}
		
		Query<Object[]> query = this.session.createQuery(hqlQuery);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(searchDetails.getTravelDate(),dtf);
		
		query.setParameter("departure", searchDetails.getDeparture());
		query.setParameter("arrival", searchDetails.getArrival());
		query.setParameter("travelDate", date);
		query.setParameter("travelClass", "%"+searchDetails.getTravelClass()+"%");
		//query.setParameter("minDur", 1);
		query.setFirstResult((searchDetails.getPageNo()-1)*Keys.MAX_NUMBER_OF_FLIGHTS_ON_ONE_PAGE);
		query.setMaxResults(Keys.MAX_NUMBER_OF_FLIGHTS_ON_ONE_PAGE);
		
		List<Object[]> resultList = query.getResultList();
		
		List<OutputFlight> flights = new ArrayList<>();
		
		float conversionRate = getConversionRate(countryCode);
		
		for(Object[] flightArr: resultList ) {
			OutputFlight ithFlight = ConvertToOutputFlight.convert(flightArr);
			ithFlight.setFare(ithFlight.getFare() * conversionRate);
			flights.add(ithFlight);			
		}
		
		return flights;
	}
	
	public float getConversionRate(String countryCode) {
		Query<Float> query = this.session.createQuery(HqlQueries.SELECT_CONVERSION_RATE_FROM_TABLE);
		query.setParameter("countryCode", countryCode);
		List<Float> result = query.getResultList();
		float rate = result.get(0);
		return rate;
	}
}
