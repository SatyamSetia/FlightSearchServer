package com.nagarro.flightsearchserver.constants;

public final class HqlQueries {

	private HqlQueries() {

	}

	/**
	 * @description HQL query for selecting direct flights from database sorted by fare.
	 */
	public static final String SELECT_DIRECT_FLIGHTS_FROM_TABLE_SORT_BY_FARE = "FROM com.nagarro.flightsearchserver.model.Flight as dbFlight WHERE dbFlight.departureLoc= :departure AND dbFlight.arrivalLoc= :arrival AND dbFlight.seatAvailability='Y' AND dbFlight.validTill>= :travelDate AND dbFlight.travelClass LIKE :travelClass ORDER BY dbFlight.fare";
	
	/**
	 * @description HQL query for selecting direct flights from database sorted by duration.
	 */
	public static final String SELECT_DIRECT_FLIGHTS_FROM_TABLE_SORT_BY_DUR = "FROM com.nagarro.flightsearchserver.model.Flight as dbFlight WHERE dbFlight.departureLoc= :departure AND dbFlight.arrivalLoc= :arrival AND dbFlight.seatAvailability='Y' AND dbFlight.validTill>= :travelDate AND dbFlight.travelClass LIKE :travelClass ORDER BY dbFlight.flightArrTime - dbFlight.flightDepTime";
	
	/**
	 * @description HQL query for selecting connected flights from database sorted by fare.
	 */
	public static final String SELECT_CONNECTED_FLIGHTS_FROM_TABLE_SORT_BY_FARE = "FROM com.nagarro.flightsearchserver.model.Flight as a, com.nagarro.flightsearchserver.model.Flight as b WHERE a.seatAvailability='Y' AND b.seatAvailability='Y'AND a.validTill>= :travelDate AND b.validTill>= :travelDate AND a.travelClass LIKE :travelClass AND b.travelClass LIKE :travelClass AND a.departureLoc= :departure AND a.arrivalLoc= b.departureLoc AND b.arrivalLoc= :arrival AND TIMEDIFF(b.flightDepTime,a.flightArrTime)>=10000 AND TIMEDIFF(b.flightDepTime, a.flightArrTime)<=100000 ORDER BY a.fare + b.fare";
	
	/**
	 * @description HQL query for selecting connecting flights from database sorted by duration. 
	 */
	public static final String SELECT_CONNECTED_FLIGHTS_FROM_TABLE_SORT_BY_DUR = "FROM com.nagarro.flightsearchserver.model.Flight as a, com.nagarro.flightsearchserver.model.Flight as b WHERE a.seatAvailability='Y' AND b.seatAvailability='Y'AND a.validTill>= :travelDate AND b.validTill>= :travelDate AND a.travelClass LIKE :travelClass AND b.travelClass LIKE :travelClass AND a.departureLoc= :departure AND a.arrivalLoc= b.departureLoc AND b.arrivalLoc= :arrival AND TIMEDIFF(b.flightDepTime,a.flightArrTime)>=10000 AND TIMEDIFF(b.flightDepTime, a.flightArrTime)<=100000 ORDER BY b.flightArrTime - a.flightDepTime";
	
	/**
	 * @description HQL query for selecting conversion rate from database.
	 */
	public static final String SELECT_CONVERSION_RATE_FROM_TABLE = "SELECT dbCurrency.conversionRate FROM com.nagarro.flightsearchserver.model.Currency as dbCurrency WHERE dbCurrency.countryCode= :countryCode";

}
