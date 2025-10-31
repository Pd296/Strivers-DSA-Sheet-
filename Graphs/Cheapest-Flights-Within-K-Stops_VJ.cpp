//Problem link:https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

using pii=pair<int,int>;
class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<int>> adjList(n); //to store adjacant list;
        vector<vector<int>> cost(n,vector<int>(n,0)); //to store price of ticket from i to j stop
        vector<int> dist(n,INT_MAX); //final result;
        //buliding adjacant list;
        for(auto& i: flights){
            int from=i[0];
            int to=i[1];
            int price=i[2];
            adjList[from].push_back(to);
            cost[from][to]=price;
        }
        queue<pii> q;
        q.emplace(0,src);
        //level-vise BFS 
        while(!q.empty() && k>=0){
            int n=q.size();
            //cout<<k<<"\n";
            while(n>0){
                n--;
                auto [price,from]=q.front();
                q.pop();
                //cout<<from<<" "<<price<<"\n";
                for(int to : adjList[from]){
                    if(cost[from][to]+price <dist[to]){
                        dist[to]=cost[from][to]+price;
                        q.emplace(dist[to],to);
                    }
                }
            }
            k--;
        }
        return dist[dst]==INT_MAX?-1:dist[dst];
        
    }
};

/*
Time complexity : O(k*E)
Space Complexity: O(n^2)*/