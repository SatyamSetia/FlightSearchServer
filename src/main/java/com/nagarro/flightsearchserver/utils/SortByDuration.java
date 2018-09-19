package com.nagarro.flightsearchserver.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;

import com.nagarro.flightsearchserver.dto.OutputFlight;

public class SortByDuration implements Comparator<OutputFlight> {

	@Override
	public int compare(OutputFlight flightOne, OutputFlight flightTwo) {
		DateFormat df = new java.text.SimpleDateFormat("hh:mm");
		long flightOneDuration = 0;
		long flightTwoDuration = 0;
		try {
			if(flightOne.isConnected()) {
				
				Date flightOneArrTime = df.parse(""+flightOne.getFlightArrTimeTwo());
				Date flightOneDepTime = df.parse(""+flightOne.getFlightDepTimeOne());
				flightOneDuration = flightOneArrTime.getTime()-flightOneDepTime.getTime();
				
				Date flightTwoArrTime = df.parse(""+flightTwo.getFlightArrTimeTwo());
				Date flightTwoDepTime = df.parse(""+flightTwo.getFlightDepTimeOne());
				flightTwoDuration = flightTwoArrTime.getTime()-flightTwoDepTime.getTime();
								
			} else {
				
				Date flightOneArrTime = df.parse(""+flightOne.getFlightArrTimeOne());
				Date flightOneDepTime = df.parse(""+flightOne.getFlightDepTimeOne());
				flightOneDuration = flightOneArrTime.getTime()-flightOneDepTime.getTime();
				
				Date flightTwoArrTime = df.parse(""+flightTwo.getFlightArrTimeOne());
				Date flightTwoDepTime = df.parse(""+flightTwo.getFlightDepTimeOne());
				flightTwoDuration = flightTwoArrTime.getTime()-flightTwoDepTime.getTime();
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return Long.compare(flightOneDuration, flightTwoDuration);
	}

}
