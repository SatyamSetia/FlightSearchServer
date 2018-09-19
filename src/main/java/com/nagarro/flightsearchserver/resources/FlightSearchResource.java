package com.nagarro.flightsearchserver.resources;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nagarro.flightsearchserver.dto.FlightSearchDetails;
import com.nagarro.flightsearchserver.dto.OutputFlight;
import com.nagarro.flightsearchserver.repo.FlightRepo;
import com.nagarro.flightsearchserver.repo.impl.FlightRepoImpl;
import com.nagarro.flightsearchserver.validations.InputValidation;

@Path("flights")
public class FlightSearchResource {
	
	@POST
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OutputFlight> getDirectFlights(@Context HttpServletRequest request, FlightSearchDetails searchDetails) {
		
		if(!InputValidation.ValidateInputs(searchDetails)) {
			return new ArrayList<>();
		}
		
		FlightRepo flightRepo = new FlightRepoImpl();
		String countryCode = request.getHeader("CountryCode");
		List<OutputFlight> flights = flightRepo.getAllDirectFlights(searchDetails,countryCode);
		if(flights.size()==0) {
			flights = flightRepo.getAllConnectedFlights(searchDetails,countryCode);
		}
		return flights;
	}

}
