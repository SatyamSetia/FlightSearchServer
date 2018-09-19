package com.nagarro.flightsearchserver.validations;

import java.util.Objects;

import com.nagarro.flightsearchserver.dto.FlightSearchDetails;

public final class InputValidation {
	
	private InputValidation() {
		
	}

	/**
	 * @param searchDetails
	 * @return boolean
	 * @description checking if inputs are valid or not.
	 */
	public static boolean ValidateInputs(FlightSearchDetails searchDetails) {
		
		boolean isArrivalValid = !Objects.isNull(searchDetails.getArrival());
		boolean isDepartureValid = !Objects.isNull(searchDetails.getDeparture());
		boolean isSortPreferenceValid = !Objects.isNull(searchDetails.getSortPreference());
		boolean isTravelClassValid = !Objects.isNull(searchDetails.getTravelClass());
		boolean isTravelDateValid = !Objects.isNull(searchDetails.getTravelDate());
		
		if(isArrivalValid && isDepartureValid && isSortPreferenceValid && isTravelClassValid && isTravelDateValid) {
			return true;
		}
		return false;
	}

}
