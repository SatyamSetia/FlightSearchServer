package com.nagarro.flightsearchserver.utils;

import com.nagarro.flightsearchserver.dto.OutputFlight;
import com.nagarro.flightsearchserver.model.Flight;

public final class ConvertToOutputFlight {
	
	private ConvertToOutputFlight() {
		
	}
	
	public static OutputFlight convert(Flight flight) {
		
		OutputFlight outputFlight = new OutputFlight();
		
		outputFlight.setConnected(false);
		outputFlight.setDeparture(flight.getDepartureLoc());
		outputFlight.setArrival(flight.getArrivalLoc());
		outputFlight.setFare(flight.getFare());
		outputFlight.setFlightArrTimeOne(flight.getFlightArrTime());
		outputFlight.setFlightDepTimeOne(flight.getFlightDepTime());
		outputFlight.setFlightNoOne(flight.getFlightNo());
		outputFlight.setTravelClass(flight.getTravelClass());
		//outputFlight.setFlightDuration(flight.getFlightDuration());
		
		return outputFlight;
	}
	
	public static OutputFlight convert(Object[] objArr) {
		
		Flight firstFlight = (Flight) objArr[0];
		Flight secondFlight = (Flight) objArr[1];
		
		OutputFlight outputFlight = new OutputFlight();
		
		outputFlight.setConnected(true);
		outputFlight.setDeparture(firstFlight.getDepartureLoc());
		outputFlight.setArrival(secondFlight.getArrivalLoc());
		outputFlight.setStop(firstFlight.getArrivalLoc());
		outputFlight.setFare(firstFlight.getFare()+secondFlight.getFare());
		outputFlight.setFlightNoOne(firstFlight.getFlightNo());
		outputFlight.setFlightNoTwo(secondFlight.getFlightNo());
		outputFlight.setFlightDepTimeOne(firstFlight.getFlightDepTime());
		outputFlight.setFlightArrTimeOne(firstFlight.getFlightArrTime());
		outputFlight.setFlightDepTimeTwo(secondFlight.getFlightDepTime());
		outputFlight.setFlightArrTimeTwo(secondFlight.getFlightArrTime());
		
		return outputFlight;
	}

}
