package core;

import parser.CityParser;
import parser.RoadParser;
import util.CSVReader;

import java.util.ArrayList;

public class RoadsHelper {

    private ArrayList<Road> roads;

    public void loadRoads(String folderName, String fileName, CitiesHelper citiesHelper){
        CSVReader reader = new CSVReader("database");

        // 00_quiz.csv is the file name
        ArrayList<String> all_roads_as_strings = reader.load("road.csv");

        for (int i = 0; i < all_roads_as_strings.size(); i++){
            System.out.println( all_roads_as_strings.get(i) );
        }

        roads = RoadParser.toRoadObjects( all_roads_as_strings, citiesHelper );

        System.out.println( "\nRoads have been loaded. Roads: " + roads.size());
    }

}
