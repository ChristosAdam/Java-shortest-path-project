package app;

import algorithm.BellmanFord;
import algorithm.Dijkstra;
import core.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import parser.CityParser;
import util.CSVReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    // core objects of the Application
    private CitiesHelper citiesHelper;
    private RoadsHelper roadsHelper;

    // visual components
    @FXML public ComboBox<String> cb_cityOrigin;
    @FXML public ComboBox<String> cb_cityDestination;
    @FXML public ComboBox<String> cb_criteria;
    @FXML public ComboBox<String> cb_algorithm;
    @FXML public TextArea         ta_result;

    /*------------------------------------------------------------------------------------------------------------------
        Event: to be executed when the button "Search" is clicked
      ------------------------------------------------------------------------------------------------------------------*/
    @FXML
    public void btnSearchClick() {
        System.out.println("\nSearch button was clicked! \n ");

        // Read the chosen options
        String cityOriginText = cb_cityOrigin.getValue();
        String cityDestinationText = cb_cityDestination.getValue();
        String searchCriteriaText = cb_criteria.getValue();
        String algorithmText = cb_algorithm.getValue();

        // debug: console prints
        System.out.println( "City Origin Name       = " + cityOriginText);
        System.out.println( "City Destination Name  = " + cityDestinationText);
        System.out.println( "Search Criteria        = " + searchCriteriaText);
        System.out.println( "Algorithm              = " + algorithmText);

        // get city objects:
        City cityOrigin = citiesHelper.getByName( cityOriginText );
        City cityDestination = citiesHelper.getByName( cityDestinationText );

        SearchResult search = null; //Initialisation aof search where we store the results of search algorithms
        //Depending what the user chose as a search criterion we create a new object of SearchResults
        if(searchCriteriaText.equals("Costs")) {
            search = new SearchResult(cityOrigin, cityDestination, SearchCriteria.Cost, 0, 0, 0, null);
        } else if(searchCriteriaText.equals("Distance"))
            search = new SearchResult(cityOrigin, cityDestination, SearchCriteria.Distance, 0, 0, 0, null);
        else if(searchCriteriaText.equals("Time"))
            search = new SearchResult(cityOrigin, cityDestination, SearchCriteria.Time, 0, 0, 0, null);

        // Search the shortest path according to the algorithm and criteria
        // algorithm = new Algorithm( roads );
        // bestRoute = algorithm.search( origin, destination, Criteria.Cost);
        // Depending what User chooses we move the execution towards there
        // There are 2 choices we need to differentiate the algorithm chosen and the criterion Distance, Cost, Time
        // First we create a new object of the algorithm and then we call the search function we the corresponding parameters
        if ( algorithmText == "Bellman Ford") {
            if (searchCriteriaText.equals("Costs")) {
                BellmanFord bellmanFord = new BellmanFord(citiesHelper.getEntireList());
                search = bellmanFord.search(cityOrigin, cityDestination, SearchCriteria.Cost);
            } else if (searchCriteriaText.equals("Distance")) {
                BellmanFord bellmanFord = new BellmanFord(citiesHelper.getEntireList());
                search = bellmanFord.search(cityOrigin, cityDestination, SearchCriteria.Distance);
            } else if (searchCriteriaText.equals("Time")) {
                BellmanFord bellmanFord = new BellmanFord(citiesHelper.getEntireList());
                search = bellmanFord.search(cityOrigin, cityDestination, SearchCriteria.Time);
            }
        }
        else if (algorithmText == "Dijkstra"){
            if (searchCriteriaText.equals("Costs")) {
                Dijkstra dijkstra = new Dijkstra(citiesHelper.getEntireList());
                search = dijkstra.search(cityOrigin, cityDestination, SearchCriteria.Cost);
            } else if (searchCriteriaText.equals("Distance")) {
                Dijkstra dijkstra = new Dijkstra(citiesHelper.getEntireList());
                search = dijkstra.search(cityOrigin, cityDestination, SearchCriteria.Distance);
            } else if (searchCriteriaText.equals("Time")) {
                Dijkstra dijkstra = new Dijkstra(citiesHelper.getEntireList());
                search = dijkstra.search(cityOrigin, cityDestination, SearchCriteria.Time);
            }
        }
        else if ( algorithmText == "Prim") {
            //We did not initialize Prim Algorithm
        }

        // Show results:
        //Depending the criterion we print the number with the measurement unit
        if(searchCriteriaText.equals("Costs"))
            ta_result.setText( algorithmText + ": The shortest path from " + cityOrigin.getName() + " to " +cityDestination.getName() + " - Cost  " + search.getTotalCost() + "$");
        else if(searchCriteriaText.equals("Distance"))
            ta_result.setText( algorithmText + ": The shortest path from " + cityOrigin.getName() + " to " +cityDestination.getName() + " - Distance " + search.getTotalDistance() + "Km");
        else if(searchCriteriaText.equals("Time"))
            ta_result.setText( algorithmText + ": The shortest path " + cityOrigin.getName() + " to " +cityDestination.getName() + " - Time " + search.getTotalTime() + " h");

    }

    /*------------------------------------------------------------------------------------------------------------------
        Method: Initialize - this will run during the windows' (visual interface) creation
      ------------------------------------------------------------------------------------------------------------------*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("\n CONTROLLER INITIALIZED \n ");

        loadData();

        loadComboBoxes();

    }

    /*------------------------------------------------------------------------------------------------------------------
        Method: Load the available options in the combo boxes
      ------------------------------------------------------------------------------------------------------------------*/
    private void loadComboBoxes() {

        // load cities
        for (City city : citiesHelper.getEntireList()) {
            if ( city.getNumberOfRoads() > 0 ) {
                cb_cityOrigin.getItems().add( city.getName() );
                cb_cityDestination.getItems().add( city.getName() );
                System.out.println(city.getName() + " - " + city.getNumberOfRoads() + " roads");

            }
            else{
                System.out.println(city.getName() + " - does not have roads" );
            }
        }

        // load criteria
        cb_criteria.getItems().add("Costs");
        cb_criteria.getItems().add("Distance");
        cb_criteria.getItems().add("Time");


        // load algorithm
        cb_algorithm.getItems().add("Dijkstra");
        cb_algorithm.getItems().add("Prim");
        cb_algorithm.getItems().add("Bellman Ford");
    }


    /*------------------------------------------------------------------------------------------------------------------
        Method: Load the data
      ------------------------------------------------------------------------------------------------------------------*/
    private void loadData(){
        citiesHelper = new CitiesHelper();
        citiesHelper.loadCities("database", "city.csv");

        roadsHelper = new RoadsHelper();
        roadsHelper.loadRoads("database", "city.csv", citiesHelper);


    }
}
