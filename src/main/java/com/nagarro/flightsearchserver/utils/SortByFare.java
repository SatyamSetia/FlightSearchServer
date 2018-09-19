package com.nagarro.flightsearchserver.utils;

import java.util.Comparator;

import com.nagarro.flightsearchserver.dto.OutputFlight;

public class SortByFare implements Comparator<OutputFlight>{

	@Override
	public int compare(OutputFlight flightOne, OutputFlight flightTwo) {
		return Float.compare(flightOne.getFare(), flightTwo.getFare());
	}
}
