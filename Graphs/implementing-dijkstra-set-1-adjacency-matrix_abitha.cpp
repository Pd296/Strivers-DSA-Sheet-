// Problem Link : https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

// User Function Template
class Solution {
  public:
    vector<int> dijkstra(int V, vector<vector<int>> &edges, int src) {
        // Code here
        vector<vector<vector<int>>> graph(V);
        // graph[0] = what are connected to 0 and its weight
        for(const auto &edge: edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            graph[src].push_back({dest, weight});
            graph[dest].push_back({src, weight});
        }
        
        priority_queue<pair<int, int>, 
        vector<pair<int, int>>, 
        greater<pair<int, int>>> pq; //store pairs in vector greater for min heap
        
        vector<int> dist(V, INT_MAX);
        
        pq.push({0, src});
        
        dist[src] = 0;
        
        while(!pq.empty()) {
            int d = pq.top().first; 
            int u = pq.top().second;
            pq.pop();
            
            if(d > dist[u]) {
                continue; //if distance whihc we got itself is more than the distance present in array its not needed as we got min onr
            }
            
            for(auto edge: graph[u]) {
                int v = edge[0];
                int wt = edge[1];
                
                if(dist[u]+wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.push({dist[v], v});
                }
            }
            
        }
        
        return dist;

        
    }
};
