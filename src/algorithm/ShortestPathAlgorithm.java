package algorithm;

import core.City;
import core.SearchCriteria;
import core.SearchResult;

import java.util.ArrayList;

public abstract class ShortestPathAlgorithm {

    protected ArrayList<City> cities;

    public ShortestPathAlgorithm( ArrayList<City> cities ){
        this.cities = cities;
    }

    public abstract SearchResult search(City origin, City destination, SearchCriteria searchCriteria);

}
