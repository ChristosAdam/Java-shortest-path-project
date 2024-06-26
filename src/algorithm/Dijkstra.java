package algorithm;

import core.*;

import java.util.ArrayList;

 public class Dijkstra extends ShortestPathAlgorithm {

     public Dijkstra(ArrayList<City> cities) {
         super(cities);
     }
     @Override
     public  SearchResult search(City origin, City destination, SearchCriteria searchCriteria) {
         int size = cities.size();                          //The size for loops and initiate key,queue and queuevisited
         double[] key = new double[size];                   //Key is the table the costs are kept
         int[] queue = new int[size];                       //Queue is needed to know which cities we have not visited

         int i;                                             // This for is just for checking
         for (i = 0; i < size; i++) {
             if (cities.get(i).getNumberOfRoads() != 0)     //If the cities have at least one road attached they are marked as not visited
                 queue[i] = 1;
             else                                           //If not they are marked with 0 which means they are visited
                 queue[i] = 0;
         }

         for (i = 0; i < size; i++) { //We initialize every city cost from the source as infinite
             key[i] = Double.POSITIVE_INFINITY;
         }


         //We take advantage of the fact that the cities have unique ids counting from 1 to 163
         //So if we subtract 1 from the city id we we get the index in the key(cost) table
         key[origin.getId() - 1] = 0;                          //The cost from source to source is zero

         int closest = SearchClosest(key, queue);   //The first search returns the minimum which is source since it is implemented as zero
         queue[closest] = 0;                        //We mark the closest in this case source as visited and it is "removed" from our queue

         while (breakCheck(queue)) {                //If every city containing roads is visited we break the loop

             //When visiting the closest city we check all the roads attached

             for (i = 0; i < cities.get(closest).getNumberOfRoads(); i++) {

                 //We access the Ith adjacent city road
                 Road roadCheck = cities.get(closest).getAdjacencies().get(i);

                 //The if help as work different for each criterion
                 if (SearchCriteria.Distance == searchCriteria) {

                     // Again we use the id of adjacent and closest cities (-1) as index
                     // If the road distance summed with the origin city distance from source is less than the adjacent distance we act accordingly
                     if ((queue[roadCheck.getDestination().getId() - 1] == 1) && (roadCheck.getDistanceKM() + key[closest] < key[roadCheck.getDestination().getId() - 1])) {

                         //We update the key table with the value of the distance of closest plus the road we are checking distance
                         key[roadCheck.getDestination().getId() - 1] = key[closest] + roadCheck.getDistanceKM();
                     }
                 }
                 else if (SearchCriteria.Cost == searchCriteria) {                  // The same as first if but for total cost
                     if ((queue[roadCheck.getDestination().getId() - 1] == 1) && (roadCheck.getTotalCost() + key[closest] < key[roadCheck.getDestination().getId() - 1])) {
                         key[roadCheck.getDestination().getId() - 1] = key[closest] + roadCheck.getTotalCost() ;
                     }
                 }else if (SearchCriteria.Time == searchCriteria) {                 // The same as first if but for Time in hours
                     if ((queue[roadCheck.getDestination().getId() - 1] == 1) && (roadCheck.getTimeHours() + key[closest] < key[roadCheck.getDestination().getId() - 1])) {
                         key[roadCheck.getDestination().getId() - 1] = key[closest] + roadCheck.getTimeHours() ;
                     }
                 }
             }

             //We search for a new closest city and then we mark it as visited
             closest = SearchClosest(key, queue);
             queue[closest] = 0;

         }

         //Configure results according to criterion
         SearchResult result = null;
         if (SearchCriteria.Distance == searchCriteria)
             result = new SearchResult(origin, destination, searchCriteria, 0, 0, key[destination.getId() -1], null);
         else if (SearchCriteria.Cost == searchCriteria)
             result = new SearchResult(origin, destination, searchCriteria, key[destination.getId() -1], 0, 0, null);
         else if (SearchCriteria.Time == searchCriteria)
             result = new SearchResult(origin, destination, searchCriteria, 0, key[destination.getId() -1], 0, null);
         return result;
     }

     private  boolean breakCheck(int[] queue) {
         int k = 0;

         //Check if every value in queue is zero meaning visited
         for(int i = 0 ; i < queue.length ; i++){
             if(queue[i] == 0){
                 k++;
             }
         }

         //If everything visited stop false
         if(k != queue.length)
             return true;
         else
             return false;
     }

     private int SearchClosest(double[] key, int[] queue) {
         int index = 0;
         double min = Double.POSITIVE_INFINITY;
         int minIndex = 0;

         //Access the key table to find the minimum and also make sure that that city is not visited yet
         for (index = 0; index < key.length ; index++) {
             if ((key[index] < min) && (queue[index] == 1)) {
                 min = key[index];
                 minIndex = index;
             }
         }

         return minIndex;
     }
 }