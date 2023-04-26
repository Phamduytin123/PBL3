package Models;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Trip {
	private int TripID;
	private String RouteID;
	private LocalTime TimeStart;
	private LocalTime TimeEnd;
	private LocalDate DateStart;
	private LocalDate DateEnd;
	public int getTripID() {
		return TripID;
	}
	public void setTripID(int tripID) {
		TripID = tripID;
	}
	public String getRouteID() {
		return RouteID;
	}
	public void setRouteID(String routeID) {
		RouteID = routeID;
	}
	public LocalTime getTimeStart() {
		return TimeStart;
	}
	public void setTimeStart(LocalTime timeStart) {
		TimeStart = timeStart;
	}
	public LocalTime getTimeEnd() {
		return TimeEnd;
	}
	public void setTimeEnd(LocalTime timeEnd) {
		TimeEnd = timeEnd;
	}
	public LocalDate getDateStart() {
		return DateStart;
	}
	public void setDateStart(LocalDate dateStart) {
		DateStart = dateStart;
	}
	public LocalDate getDateEnd() {
		return DateEnd;
	}
	public void setDateEnd(LocalDate dateEnd) {
		DateEnd = dateEnd;
	}
	@Override
	public String toString() {
		return "Trip [TripID=" + TripID + ", RouteID=" + RouteID + ", TimeStart=" + TimeStart + ", TimeEnd=" + TimeEnd
				+ ", DateStart=" + DateStart + ", DateEnd=" + DateEnd + "]";
	}
	public Trip(int tripID, String routeID, LocalTime timeStart, LocalTime timeEnd, LocalDate dateStart, LocalDate dateEnd) {
		super();
		TripID = tripID;
		RouteID = routeID;
		TimeStart = timeStart;
		TimeEnd = timeEnd;
		DateStart = dateStart;
		DateEnd = dateEnd;
	}
}
