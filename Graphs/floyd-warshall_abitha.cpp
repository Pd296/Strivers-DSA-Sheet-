Problem Link : https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

// User function template for C++

class Solution {
  public:
    void floydWarshall(vector<vector<int>> &dist) {
        // Code here
        int v = dist.size();
        
        for(int in = 0;in < v;in++) {
            for(int i = 0;i < v;i++) {
                for(int j = 0;j < v;j++) {
                    if(dist[i][in] != 1e8 && dist[in][j] != 1e8) {
                        dist[i][j] = min(dist[i][j], dist[i][in] + dist[in][j]);
                    }
                }
            }
        }
    }
};
