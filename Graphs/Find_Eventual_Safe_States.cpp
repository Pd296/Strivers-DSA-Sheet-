//Problem link :https://leetcode.com/problems/find-eventual-safe-states/description/

//vis array definition
// 0 -> unvisited node , can do dfs
// 1 -> currently under process in dfs stack
// 2 -> safe node 
// 3 -> unsafe node
class Solution {
public:
    vector<int> vis;
    bool dfs(vector<vector<int>>& graph,int node){
        if(graph[node].size()==0 || vis[node]==2)
        return true;
        if(vis[node]==3) return false;
        if(vis[node]==1) return false;
        vis[node]=1;
        for(auto& i: graph[node]){
            if(vis[i]==1) return false;
            if(!dfs(graph,i))
            return false;
        }
        vis[node]=2;
        return true;
    }
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n=graph.size();
        vis.resize(n,0);
        vector<int> result;
        for(int i=0;i<n;i++){
            //vis.resize(n,0);
            if(graph[i].size()==0 || dfs(graph,i)){
                result.push_back(i);
                vis[i]=2;
            }else{
               vis[i]=3;
            }
        }
        return result;
    }
};