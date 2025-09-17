/*

  Problem Link : https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/0
  Date : 17th September 2025

 */

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {

       int[] distance = new int[V];
       Arrays.fill(distance,(int)1e8);
       distance[src]=0;
       
       // traverse V-1 times over all edges 
       for(int i=1;i<=V-1;i++){
           
            for(int[] arr: edges){
                int from = arr[0];
                int to = arr[1];
                int wt = arr[2];
                
                if(distance[from] == (int)1e8) continue; //if from node is not reachable yet 
                if(distance[from] + wt < distance[to]){
                    distance[to] = distance[from] + wt;
                }
            }
       }
       
       //check for negative weight cycle (N th iteration)
       for(int[] arr: edges){
            int from = arr[0];
                int to = arr[1];
                int wt = arr[2];
                
                if(distance[from] == (int)1e8) continue;
                if(distance[from] + wt < distance[to]){
                    return new int[]{-1}; //negative cycle exists 
                }
       }
       
       return distance;
      
    }
}
