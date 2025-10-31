//Problem link: https://leetcode.com/problems/is-graph-bipartite/

class Solution {
public:
    vector<int> vis;
    bool dfs(vector<vector<int>>& graph, int node,int color){
        if(vis[node]!=-1){
            return vis[node]==color;
        }
        vis[node]=color;
        for(auto& i: graph[node]){
            if(!dfs(graph,i,!color))
            return false;
        }
        return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        int n=graph.size();
        vis.resize(n,-1);
        for(int i=0;i<n;i++){
            if(vis[i]==-1)
            if(!dfs(graph,i,0)) return false;
            
        }
        // if(!dfs(graph,0,0)) return false;
        // if(n>1 && vis[1]==-1 && !dfs(graph,1,0)) return false;
        return true;
    }
};