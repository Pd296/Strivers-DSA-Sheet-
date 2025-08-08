Link : https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1


// User Function Template
using pa=pair<int,int>;
class Solution {
  public:
    vector<int> dijkstra(int V, vector<vector<int>> &edges, int src) {
        // Code here
       
        vector<vector<pa>> adj(V);
        vector<int> result(V,INT_MAX);
        for(auto& i:edges){
            adj[i[0]].push_back({i[1],i[2]});
            adj[i[1]].push_back({i[0],i[2]});
        }
        priority_queue<pa,vector<pa>,greater<pa>> pq1;
        pq1.emplace(src,0);
        while(!pq1.empty()){
            auto [node,wei]=pq1.top();
            pq1.pop();
            if(result[node]<wei)continue;
            for(auto& [k,w]:adj[node]){
                if(result[k]>(wei+w)){
                  result[k]=min(result[k],wei+w);
                  pq1.emplace(k,wei+w);
                }
            }
        }
        result[src]=0;
        return result;
    }
};
