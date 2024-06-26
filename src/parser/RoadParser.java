package parser;

import java.util.ArrayList;

import core.CitiesHelper;
import core.City;
import core.Road;

public class RoadParser {

	/* ArrayList<String> and convert to ArrayList<Warehouse> returning this list
	 ----------------------------------------------------------------------------------------------*/
	public static ArrayList<Road> toRoadObjects(ArrayList<String> records, CitiesHelper citiesHelper){
		
		ArrayList<Road> roads = new ArrayList<Road>();
		
		// RoadId Group	OriginCityId OriginCityName	Paths AdjacencyId AdjacencyCityName DistanceKM	TimeHours	FuelCost	TollCost	DriverCost	Period
		for (String record : records) {
			String[] elements = record.split(",");
			
			int roadId = Integer.parseInt(elements[0]);
			int originCityId = Integer.parseInt(elements[2]);
			City origin = citiesHelper.getById(originCityId);
		
			int destinationCityId = Integer.parseInt(elements[5]);
			City destination = citiesHelper.getById(destinationCityId);
			
			double distanceKM = Double.parseDouble(elements[7]);	
			double timeHours = Double.parseDouble(elements[8]);	
			double fuelCost = Double.parseDouble(elements[9]);	
			double tollCost = Double.parseDouble(elements[10]);	
			double driverCost = Double.parseDouble(elements[11]);	
		
			Road road = new Road(roadId,  origin,  destination,  distanceKM,  timeHours,	
					 fuelCost,  tollCost,  driverCost);
			
			origin.getAdjacencies().add(road);

			roads.add(road);
			
		}
		
		return roads;
	}

}
