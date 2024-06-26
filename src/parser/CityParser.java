/*------------------------------------------------------------------------------------------------------------
 	eFlow2W - Project of Computation III
 	
 	Group members:
 		- Student (Student number)
 		- Student (Student number)
 		- Student (Student number)
 		
*------------------------------------------------------------------------------------------------------------
	City Parser
*------------------------------------------------------------------------------------------------------------*/

package parser;

import java.util.ArrayList;

import core.City;
import util.CSVHelper;

public final class CityParser {
	
	/* toCityObjects
	   Convert a list of Strings in a list of cities
	 ----------------------------------------------------------------------------------------------*/
	public static ArrayList<City> toCityObjects(ArrayList<String> all_cities_as_strings){
		
		ArrayList<City> cities_objects = new ArrayList<City>();
		
		//CityName, CityId, DistrictName, CityHasWarehouse, HasRoad, Roads
		for (String city_line : all_cities_as_strings) {
			String[] elements = city_line.split(",");
			
			String name = elements[0];
			int id = Integer.parseInt(elements[1]);
			String district = elements[2];
			boolean hasWarehouse = elements[3].equals("Yes");
			// boolean hasRoad = elements[4].equals("Yes");

			// int nRoads = Integer.parseInt(elements[5]);
			City city = new City(id, name, district, hasWarehouse);

			cities_objects.add( city );
			//City city = new City(id, name, district, hasWarehouse);
		}
		return cities_objects;
	}
	
	/* toCSVRecords
	   Convert a list of cities to a list of Strings (CSV struture)
	 ----------------------------------------------------------------------------------------------*/
	public static ArrayList<String> toCSVRecords(ArrayList<City> cities){
		ArrayList<String> records = new ArrayList<String>();
		
		for(City city : cities) {
			
			String hasWarehouse = city.hasWarehouse()?"Yes":"No";
			String hasRoad = city.hasRoad()?"Yes":"No";
			
			records.add(city.getName() + CSVHelper.FIELD_SEPARATOR + 
					    city.getId()  + CSVHelper.FIELD_SEPARATOR + 
					    city.getDistrict() + CSVHelper.FIELD_SEPARATOR + 
					    hasWarehouse + CSVHelper.FIELD_SEPARATOR  +
					    hasRoad );
		}
		
		return records;
	}

	
}
