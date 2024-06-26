/*------------------------------------------------------------------------------------------------------------
 	eFlow2W - Project of Computation III
 	
 	Group members:
 		- Student (Student number)
 		- Student (Student number)
 		- Student (Student number)
 		
*------------------------------------------------------------------------------------------------------------
	City
*------------------------------------------------------------------------------------------------------------*/

package core;

import java.util.ArrayList;


public class City {
	/* Member variables
	 *-----------------------------------------------------------------------------------------------------*/
	private String name;
	private int id ;
	private String district;
	private boolean hasWarehouse;

	
	private ArrayList<Road> adjacencies;
	
	/* Constructor 1
	 *-----------------------------------------------------------------------------------------------------*/
	public City() {
		adjacencies = new ArrayList<Road>();
	}
	
	/* Constructor 2 (with data)
	 *-----------------------------------------------------------------------------------------------------*/
	public City(int id, String name, String district, boolean hasWarehouse) {
		
		this();
		
		this.id = id;
		this.name = name;
		this.district = district;
		this.hasWarehouse = hasWarehouse;
	}
	
	/* Getters and Setters
	 *-----------------------------------------------------------------------------------------------------*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public boolean hasWarehouse() {
		return hasWarehouse;
	}
	public void setHasWarehouse(boolean hasWarehouse) {
		this.hasWarehouse = hasWarehouse;
	}
	
	/* hasRoads is based on the adjacencies
	 *-----------------------------------------------------------------------------------------------------*/
	public boolean hasRoad() {
		return adjacencies.size() > 0;
	}

	/* hasRoads is based on the quantity of adjacencies
	 *-----------------------------------------------------------------------------------------------------*/
	public int getNumberOfRoads() {
		return adjacencies.size();
	}
	
	/* return the list of adjacencies
	 *-----------------------------------------------------------------------------------------------------*/
	public ArrayList<Road> getAdjacencies() {
		return adjacencies;
	}
}
