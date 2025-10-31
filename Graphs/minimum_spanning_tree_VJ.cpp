//problem link:https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

using pii=pair<int,int>;
class Solution {
  public:
    int spanningTree(int V, vector<vector<int>>& edges) {
        // code here
        vector<vector<int>> adjList(V);
        vector<vector<int>> adjWeight(V,vector<int>(V,0));
        vector<int> visited(V,0);
        int mstCount=0,mstCost=0;
        priority_queue<pii,vector<pii>,greater<pii>> pq;
        for(auto i: edges){
            int u=i[0];
            int v=i[1];
            int weight=i[2];
            adjList[u].push_back(v);
            adjList[v].push_back(u);
            adjWeight[u][v]=weight;
            adjWeight[v][u]=weight;
        }
        //prim's algorthim
        for(auto i:adjList[0]){
            pq.emplace(adjWeight[0][i],i);
        }
        visited[0]=1;
        while(!pq.empty() && mstCount!=V-1){
            auto [weig,node]=pq.top();
           // cout<<weig<<" "<<node<<"\n";
            pq.pop();
            if(visited[node]==1) continue;
            mstCount++;
            mstCost+=weig;
            visited[node]=1;
            for(auto i:adjList[node]){
                if(visited[i]==0){
                    pq.emplace(adjWeight[node][i],i);
                }
            }
        }
        return mstCost;
    }
};