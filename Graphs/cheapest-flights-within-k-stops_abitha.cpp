
Problem Link : https://leetcode.com/problems/cheapest-flights-within-k-stops/

class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<pair<int,int>> graph[n]; //create graph
        for(auto it: flights) {
            graph[it[0]].push_back({it[1], it[2]});
        }

        queue<pair<int, pair<int, int>>> q;
        //stops,{node, dist}
        q.push({0,{src, 0}});
        vector<int> dist(n, 1e9);
        dist[src] = 0;

        while(!q.empty()) {
            auto it = q.front();
            q.pop();
            int stops = it.first;
            int node = it.second.first;
            int distance = it.second.second;

            if(stops > k){
                continue;
            }
            for(auto adj: graph[node]) {
                int adjNode = adj.first;
                int adjDis = adj.second;
                
                if(distance+adjDis < dist[adjNode] && stops <= k) {
                    dist[adjNode] = distance+adjDis;
                    q.push({stops+1, {adjNode,distance+adjDis }});
                }
            }
        } 
        if(dist[dst] == 1e9) return -1;
        return dist[dst];
    }
};
