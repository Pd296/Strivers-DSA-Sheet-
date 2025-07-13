// Problem Link : https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

class Solution {
  public:
    bool canColor(int ind, vector<vector<int>>&graph, vector<int>& color, int m, int v) {
        for(int i = 0;i < v;i++) {
            // in graph thatif we are having an edge then for that node we shouldnt have same color
            if(graph[ind][i] == 1 && color[i] == m) {
                return false;
            }
        }
        return true;
    }
    bool solve(int ind, vector<vector<int>>&graph, vector<int>& color, int m, int v) {
        if(ind == v) {
            return true;
        }
        for(int i = 1; i<= m; i++) { //checking colors for that node from 1 to m
            if(canColor(ind, graph,color,i,v)) {
                color[ind] = i;
                if(solve(ind+1, graph, color, m, v) == true) {
                    return true;
                }
                color[ind] = 0;
            }
        }
        return false;
    }
    bool graphColoring(int v, vector<vector<int>> &edges, int m) {
        // code here
        vector<vector<int>> graph(v, vector<int>(v,0));  //v rows, each row with v cols of value 0
        for(int i = 0; i < edges.size();i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }
        vector<int> color(v,0);
        return solve(0,graph, color, m, v);
    }
};



