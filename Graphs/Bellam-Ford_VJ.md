// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

#### Bellam-Ford :

use :
    This Algo is used to find shortest distance between two nodes .It is also used to detect negative cycles in Graph. 

    When we run V-1 times , the edges and update distance everytime whenever a shorter distance to dest. After first loop , short distance between two nodes are stored in dist array. 
    if we run V-1 times again , we should not be able to get shorter distance than existing one. if we get shorter distance , we have negative cycle in graph. By using this algo , we can find number of vertices which are part of negative cycle. 

    For same porblem , if we use Dijkstra's algorithm, it will not able to calculate shorted distance . it will result in either TLE or MLE(due to storage in priority_queue).

Time complexity : O(V.E)
Space complexity : O(E)



```
class Solution {
  public:
    vector<int> bellmanFord(int V, vector<vector<int>>& edges, int src) {
        // Code here
        vector<int> dist(V,1e8);
        dist[src]=0;
        //runs V-1 times every edges to calculate shortest distance
        for(int i=0;i<V-1;i++){
            for(auto edge: edges){
                if(dist[edge[0]]!=1e8 && (dist[edge[0]]+edge[2])<dist[edge[1]]){
                    dist[edge[1]]=dist[edge[0]]+edge[2];
                    
                }
            }
        }
        //reruns V-1 times every edges to detect negative cycle
        // Dist array already have shortest distance , if we encounter a shorter distance then existing one ,then that particular edges is part of negative cycle.
        for(int i=0;i<V-1 ;i++){
            
            for(auto edge: edges){
                if(dist[edge[0]]!=1e8 && (dist[edge[0]]+edge[2])<dist[edge[1]]){
                    dist[edge[1]]=INT_MIN;
                    
                    return {-1};
                }
            }
        }
        return dist;
    }
};
```
