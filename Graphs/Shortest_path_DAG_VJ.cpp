//Problem link https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
// User function Template for C++
using pii=pair<int,int>;
class Solution {
  public:
    vector<int> shortestPath(int V, int E, vector<vector<int>>& edges) {
        // code here
        vector<vector<int>> weight(V,vector<int>(V,0));// matrix for path weights
        vector<vector<int>> adjList(V);// adjcancy list for graph traversal
        vector<int> dist(V,INT_MAX);// result 
        for(auto& i:edges){
            adjList[i[0]].push_back(i[1]);
            weight[i[0]][i[1]]=i[2];
        }
        priority_queue<pii,vector<pii>,greater<pii>>pq;
        pq.push({0,0});
        dist[0]=0;
        while(!pq.empty()){
            auto [cost,from]=pq.top();
            pq.pop();
            for(auto i:adjList[from]){
                if(weight[from][i]+cost <dist[i]){
                    dist[i]=weight[from][i]+cost;
                    pq.push({cost+weight[from][i],i});
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==INT_MAX)
            dist[i]=-1;
        }
        return dist;
    }
};
