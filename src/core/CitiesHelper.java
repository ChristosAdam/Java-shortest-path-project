/*------------------------------------------------------------------------------------------------------------
 	eFlow2W - Project of Computation III
 	
 	Group members:
 		- Student (Student number)
 		- Student (Student number)
 		- Student (Student number)
 		
*------------------------------------------------------------------------------------------------------------
	Controller of City list (cities loaded in the system)
*------------------------------------------------------------------------------------------------------------*/

package core;

import parser.CityParser;
import util.CSVReader;

import java.util.ArrayList;

public class CitiesHelper {
	
	private ArrayList<City> cities;
	
	
	/* Constructor
	 *-----------------------------------------------------------------------------------------------------*/
	public CitiesHelper(){
		this.cities = new ArrayList<City>();
	}
	
	/* Constructor 2: which receives an array of cities (cities loaded)
	 *-----------------------------------------------------------------------------------------------------*/
	public CitiesHelper(ArrayList<City> cities){
		this();
		this.cities = cities;
	}
	
	/* get a city according to the index in array
	 *-----------------------------------------------------------------------------------------------------*/
	public City get(int index) {
		return cities.get(index);
	}
	
	
	/* quantity of the cities in the array
	 *-----------------------------------------------------------------------------------------------------*/
	public int size() {
		return cities.size();
	}
	
	
	/* add a city to the array
	 *-----------------------------------------------------------------------------------------------------*/
	public void add(City city) {
		cities.add(city);
	}
	
	
	/* delete a city from the array
	 *-----------------------------------------------------------------------------------------------------*/
	public void delete(int index) {
		cities.remove(index);
	}
	
	public ArrayList<City> getEntireList(){
		return cities;
	}
	
	
	/* Get a city by CityId 
	 ----------------------------------------------------------------------------------------------*/
	public City getById(int id) {
		City city = null;
		
		for (int i = 0 ; i < cities.size(); i++) {
			city = cities.get(i);
			if (city.getId() == id) return city;
		}
		
		return null;
	}
	
	/* Get a city by City Name 
	 ----------------------------------------------------------------------------------------------*/
	public City getByName(String cityName) {
		City city = null;
		
		for (int i = 0 ; i < cities.size(); i++) {
			city = cities.get(i);
			if (city.getName() == cityName) return city;
		}
		
		return null;
	}
	
	/* Get next CityId (Bigger CityId to be used by a new city)
	 ----------------------------------------------------------------------------------------------*/
	public int getNextId() {
		City city = null;
		int biggerId = 0;
		
		for (int i = 0 ; i < cities.size(); i++) {
			city = cities.get(i);
			if (city.getId() > biggerId ) biggerId = city.getId();
		}
		
		return biggerId + 1;
		
		// Remark: this code can be optimized.
	}

	public void loadCities( String folderName, String fileName){
		//Syttem.out.println("Hi");
		CSVReader reader = new CSVReader("database");

		// 00_quiz.csv is the file name
		ArrayList<String> all_cities_as_strings = reader.load("city.csv");

		for (int i = 0; i < all_cities_as_strings.size(); i++){
			System.out.println( all_cities_as_strings.get(i) );
		}

		cities = CityParser.toCityObjects( all_cities_as_strings );

		System.out.println( "\nCities have been loaded. Cities: " + cities.size());
	}
}
