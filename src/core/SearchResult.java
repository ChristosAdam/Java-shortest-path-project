package core;

import java.util.ArrayList;

public class SearchResult {

    private City           origin;
    private City           destination;
    private SearchCriteria searchCriteria;
    private double         totalCost;
    private double         totalTime;
    private double         totalDistance;

    private ArrayList<City> route;

    public SearchResult(City origin, City destination, SearchCriteria searchCriteria,
                        double totalCost, double totalTime, double totalDistance,
                        ArrayList<City> route){

        this.origin = origin;
        this.destination = destination;
        this.searchCriteria = searchCriteria;
        this.totalCost = totalCost;
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
        this.route = route;
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

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public ArrayList<City> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<City> route) {
        this.route = route;
    }
}
