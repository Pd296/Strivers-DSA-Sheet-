/* 

  Problem Link : https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
  Date : 3rd September 2025
 
 */

//stores the node and cost
class Point{
    int node;
    int cost;
    Point(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
}

//store the Stops 
class Stops{
    int node;
    int stopsTaken;
    int costSoFar;
    Stops(int node,int stopsTaken,int costSoFar){
        this.node=node;
        this.stopsTaken=stopsTaken;
        this.costSoFar=costSoFar;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<Point>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] distance = new int[n]; 
        Arrays.fill(distance,Integer.MAX_VALUE);

        //create adj list 
        for(int[] arr : flights){

            int from = arr[0];
            int to = arr[1];
            int cost = arr[2];

            Point point = new Point(to,cost);
            adj.get(from).add(point);
        }

        // Djikistras algorithm with Stops (not with distance)
        Queue<Stops> queue = new LinkedList<>();
        queue.offer(new Stops(src,0,0));
        distance[src]=0;
        int minCost = Integer.MAX_VALUE;
         
        while(!queue.isEmpty()){

            Stops current = queue.poll();
            int currNode = current.node;
            int stopsTaken = current.stopsTaken;
            int costSoFar = current.costSoFar;

            if(stopsTaken > k ) continue; 
            
            List<Point> neighbours = adj.get(currNode);
            for(Point neighbour : neighbours){
               
                int adjNode = neighbour.node;
                int cost = neighbour.cost;
                int totalCost = costSoFar + cost;

                if(totalCost < distance[adjNode]){
                  distance[adjNode]=totalCost;
                  queue.offer(new Stops(adjNode,stopsTaken+1,totalCost));
                }
            } 
        }

        return distance[dst] != Integer.MAX_VALUE ? distance[dst] : -1;

    }
}