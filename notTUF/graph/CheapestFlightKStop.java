/*
  787. Cheapest Flights Within K Stops
  Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

  Approach : Dijkstra's varient
    Use array to keep track of cheapest fair to all destination cities and queue the intermediate city which has lesser than k stops and minimal cost so far 
  Time complexity : ?
  Space complexity: ?
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        FlightFinder flightFinder = new FlightFinder(n, flights);
        flightFinder.generateAllDestCheapestFair(src, dst, k);
        return flightFinder.getCheapestFair(dst);
    }
}

class Node{
    int city;
    int stop;
    int cost;
    
    Node(int node, int stop, int cost){
        this.city = node;
        this.stop = stop;
        this.cost = cost;
    }
}

class FlightFinder{
    HashMap<Integer, HashMap<Integer, Integer>> flightRoutes;
    int[] allDestinationCheapestFair;

    FlightFinder(int n, int[][] flights){
        this.allDestinationCheapestFair = new int[n];
        Arrays.fill(this.allDestinationCheapestFair, Integer.MAX_VALUE);

        this.flightRoutes = new HashMap<>();

        for(int[] route: flights){
            HashMap<Integer, Integer> costMap;
            if(this.flightRoutes.containsKey(route[0])){
                costMap  = this.flightRoutes.get(route[0]);
            }
            else{
                costMap = new HashMap<>();
            }
            costMap.put(route[1], route[2]);
            this.flightRoutes.put(route[0], costMap);
        }

    }

    public void generateAllDestCheapestFair(int src, int dest, int k){
        Queue<Node> queue = new LinkedList<>();
        this.allDestinationCheapestFair[src] = 0;
        queue.add(new Node(src, 0, 0));

        while(!queue.isEmpty()){
            Node currentCity = queue.remove();
            HashMap<Integer, Integer> destinationMap = flightRoutes.get(currentCity.city);
            if(destinationMap == null || currentCity.city == dest || currentCity.stop > k)
                continue;

            for(Map.Entry<Integer, Integer> item : destinationMap.entrySet()){
                int destination = item.getKey();
                int costSoFar = item.getValue() + currentCity.cost;
                if(allDestinationCheapestFair[destination] >  costSoFar ){
                    allDestinationCheapestFair[destination]  =  costSoFar;
                    queue.add(new Node(destination, currentCity.stop+1, costSoFar));
                }    
            }    

        }
        
    }


    public int getCheapestFair(int dest){
        if(allDestinationCheapestFair[dest] == Integer.MAX_VALUE ) return -1;
        return allDestinationCheapestFair[dest];
    }

}
