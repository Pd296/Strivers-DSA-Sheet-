//Problem link: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

using pli=pair<long long,int>;
class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        //adjcant list to store time and node
        vector<vector<pli>> adjList(n);
        //list to store no.of ways to reach ith node
        vector<int> minWays(n,0);
        //list to stor min time to reach ith node
        vector<long long> steps(n,LONG_MAX);
        int mod=1e9+7;
        priority_queue<pli,vector<pli>,greater<pli>> pq; //Priority queue for dijkarths
        //building graph from edges
        for(auto& road:roads){
            int u=road[0];
            int v=road[1];
            int time=road[2];
            adjList[u].push_back({time,v});
            adjList[v].push_back({time,u});
        }
        minWays[0]=1;
        steps[0]=0;
        pq.emplace(0,0);
        //dijkarths algo 
        while(!pq.empty()){
            auto [currTime,currNode]=pq.top();
            pq.pop();
            for(auto& [time,toNode]: adjList[currNode]){
                //if there is shorter time available , take shorter time
                if(currTime+time<steps[toNode]){
                    steps[toNode]=steps[currNode]+time;
                    minWays[toNode]=minWays[currNode];
                    pq.emplace(steps[toNode],toNode);
                }else if(currTime+time==steps[toNode]){ 
        //if there is same time available to reach node , no.of ways will increased by currnode's ways
                    minWays[toNode]=(minWays[currNode]+minWays[toNode])%mod;
                }
            }
        }
        return minWays[n-1];
    }
};