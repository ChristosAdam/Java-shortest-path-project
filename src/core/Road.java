/*------------------------------------------------------------------------------------------------------------
 	eFlow2W - Project of Computation III
 	
 	Group members:
 		- Student (Student number)
 		- Student (Student number)
 		- Student (Student number)
 		
*------------------------------------------------------------------------------------------------------------
	Road
*------------------------------------------------------------------------------------------------------------*/

package core;

public class Road {
	private int roadId;
	private City origin;
	private City destination;
	private double distanceKM ;	
	private double timeHours;	
	private double fuelCost;	
	private double tollCost ;	
	private double driverCost;
	
	public Road(int roadId, City origin, City destination, double distanceKM, double timeHours,	
			double fuelCost, double tollCost, double driverCost) {
		this.roadId = roadId;
		this.origin = origin;
		this.destination = destination;
		this.distanceKM = distanceKM;	
		this.timeHours = timeHours;	
		this.fuelCost = fuelCost;	
		this.tollCost = tollCost;	
		this.driverCost = driverCost;
	}
	
	public int getRoadId() {
		return roadId;
	}

	public void setRoadId(int roadId) {
		this.roadId = roadId;
	}

	public City getOrigin() {
		return origin;
	}

	public void setOrigin(City origin) {
		this.origin = origin;
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

	public double getDistanceKM() {
		return distanceKM;
	}

	public void setDistanceKM(double distanceKM) {
		this.distanceKM = distanceKM;
	}

	public double getTimeHours() {
		return timeHours;
	}

	public void setTimeHours(double timeHours) {
		this.timeHours = timeHours;
	}

	public double getFuelCost() {
		return fuelCost;
	}

	public void setFuelCost(double fuelCost) {
		this.fuelCost = fuelCost;
	}

	public double getTollCost() {
		return tollCost;
	}

	public void setTollCost(double tollCost) {
		this.tollCost = tollCost;
	}

	public double getDriverCost() {
		return driverCost;
	}

	public void setDriverCost(double driverCost) {
		this.driverCost = driverCost;
	}

	public double getTotalCost(){return getTollCost() + getDriverCost() + getFuelCost();}
}
