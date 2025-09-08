/*

  Problem Link : https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
  Date : 8th September 2025
  
 */

class Point{
    int node;
    long cost;
    Point(int node,long cost){
        this.node=node;
        this.cost=cost;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
         
         int mod = (int)(1e9) + 7;
         long[] distance = new long[n];
         int[] ways = new int[n];
         List<List<Point>> adj = new ArrayList<>();
         for(int i=0;i<n;i++)adj.add(new ArrayList<>());

         //create the adj list
         for(int[] arr : roads){

            int from = arr[0];
            int to = arr[1];
            long cost = arr[2];

            adj.get(from).add(new Point(to,cost));
            adj.get(to).add(new Point(from,cost));
         }
         
         Arrays.fill(distance,Long.MAX_VALUE);
         PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> (int)(a.cost - b.cost)); 
         pq.offer(new Point(0,0));
         ways[0]=1;
         distance[0]=0;

         while(!pq.isEmpty()){

             Point current = pq.poll();
             int currNode = current.node;
             long cost = current.cost;

             if(distance[currNode] < cost) continue;
             
             List<Point> neighbours = adj.get(currNode);
             for(Point neighbour : neighbours){

                 int adjNode = neighbour.node;
                 long costForAdjNode = neighbour.cost;

                 long totalCost = cost + costForAdjNode;
                 if(totalCost < distance[adjNode] ){
                    distance[adjNode] = totalCost;
                    ways[adjNode] = (ways[currNode]%mod);
                    ways[adjNode]%=mod;
                    pq.offer(new Point(adjNode,totalCost));
                 }else if(totalCost == distance[adjNode]){
                    ways[adjNode] += (ways[currNode]%mod);
                    ways[adjNode]%=mod;
                 }
             }
         }

         return ways[n-1];
    }
}