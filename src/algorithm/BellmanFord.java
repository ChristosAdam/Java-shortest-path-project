package algorithm;

import core.City;
import core.Road;
import core.SearchCriteria;
import core.SearchResult;

import java.util.ArrayList;

public class BellmanFord extends ShortestPathAlgorithm {
    public BellmanFord(ArrayList<City> cities) {
        super(cities);
    }

    @Override
    public SearchResult search(City origin, City destination, SearchCriteria searchCriteria) {

        // Initialize the distance to all nodes to be infinity
        // except for the start node which is zero.
        int E = cities.size();
        double[] dist = new double[E];                  // Create distance table for each city
        int i=0;
        int V = 0;
        for(i=0; i<E;i++) {                             // Find the number of roads count every city's number of roads
            for (int j = 0; j < cities.get(i).getNumberOfRoads(); j++) { V++; }
        }

        ArrayList<Road>[] graph = createGraph(V);       // Create a graph for each road

        for(i=0; i<E;i++){
            for(int j = 0; j<cities.get(i).getNumberOfRoads() ; j++) { // Insert every road in the graph
                addEdge(graph, cities.get(i).getId(), cities.get(i).getAdjacencies().get(j));
            }
        }

        java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);          // Put every distance to infinity
        dist[origin.getId() - 1] = 0;                                   // Make the source from source distance 0
        double ComparedCriterion = 0;                                   // Initiate compared criterion for the loop
        // For each vertex, apply relaxation for all the edges
        for (i = 0; i < V - 1; i++) {                                   // Repeat for number of roads minus 1
            for (ArrayList<Road> edges : graph) {                       // For each edge get the compared criterion according to search Criteria
                for (Road edge : edges) {
                    if(SearchCriteria.Distance == searchCriteria)
                        ComparedCriterion = edge.getDistanceKM();
                    else if(SearchCriteria.Cost == searchCriteria )
                        ComparedCriterion = edge.getTotalCost();
                    else if(SearchCriteria.Time == searchCriteria)
                        ComparedCriterion = edge.getTimeHours();

                    //Compare the distance of adjacent with the distance of origin plus the road
                    if (dist[edge.getOrigin().getId() - 1] + ComparedCriterion < dist[edge.getDestination().getId() - 1])
                        dist[edge.getDestination().getId() - 1] = dist[edge.getOrigin().getId() - 1] + ComparedCriterion;
                }
            }
        }
        // Run algorithm a second time to avoid a negative circle if the distances get smaller we have a negative circle
        for (i = 0; i < V - 1; i++) {
            for (ArrayList<Road> edges : graph) {
                for (Road edge : edges) {
                    if(SearchCriteria.Distance == searchCriteria)
                        ComparedCriterion = edge.getDistanceKM();
                    else if(SearchCriteria.Cost == searchCriteria )
                        ComparedCriterion = edge.getTotalCost();
                    else if(SearchCriteria.Time == searchCriteria)
                        ComparedCriterion = edge.getTimeHours();
                    if (dist[edge.getOrigin().getId() - 1] + ComparedCriterion < dist[edge.getDestination().getId() - 1])
                        dist[edge.getDestination().getId() - 1] = Double.NEGATIVE_INFINITY;
                }
            }
        }
        // Return the result containing the minimum to the specified city according to the corresponding criterion
        SearchResult result = null;
        if (SearchCriteria.Distance == searchCriteria)
            result = new SearchResult(origin, destination, searchCriteria, 0, 0, dist[destination.getId() -1], null);
        else if (SearchCriteria.Cost == searchCriteria)
            result = new SearchResult(origin, destination, searchCriteria, dist[destination.getId() -1], 0, 0, null);
        else if (SearchCriteria.Time == searchCriteria)
            result = new SearchResult(origin, destination, searchCriteria, 0, dist[destination.getId() -1], 0, null);

        return result;
    }


    // Create the graph for the roads
    public static ArrayList<Road>[] createGraph(final int V) {
        ArrayList<Road>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        return graph;
    }

    // Function to help us fill the graph
    public static void addEdge(ArrayList<Road>[] graph,int from, Road road) {
        graph[from].add(road);
    }

}








