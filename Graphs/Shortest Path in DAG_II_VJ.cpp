//Problem link:https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

class Solution {
  public:
    // Function to find the shortest path from source to all other nodes
    vector<int> shortestPath(vector<vector<int>>& adj, int src) {
        // code here
         vector<int> dist(adj.size(),INT_MAX);
         dist[src]=0;
         queue<int> pq;
         pq.push(src);
         while(!pq.empty()){
             int from=pq.front();
             pq.pop();
             for(int& to:adj[from]){
                 if(dist[from]+1<dist[to]){
                     dist[to]=dist[from]+1;
                     pq.push(to);
                 }
             }
         }
         for(int i=0;i<adj.size();i++){
             if(dist[i]==INT_MAX)
             dist[i]=-1;
         }
         return dist;
    }
};