Problem Link : https://www.geeksforgeeks.org/problems/distinct-coloring--170645/1

// User function Template for C++

class Solution {
  public:
    long long int distinctColoring(int N, int r[], int g[], int b[]) {
        // code here
        vector<long long int> dpR(N, -1);
        vector<long long int> dpB(N, -1);
        vector<long long int> dpG(N, -1);
        dpR[0] = r[0];
        dpB[0] = b[0];
        dpG[0] = g[0];
        for(int i = 1;i<N;i++) {
            dpR[i] = min(r[i]+dpB[i-1], r[i]+dpG[i-1]);
            dpB[i] = min(b[i]+dpR[i-1], b[i]+dpG[i-1]);
            dpG[i] = min(g[i]+dpB[i-1], g[i]+dpR[i-1]);
        }
        return min({dpR[N-1], dpB[N-1], dpG[N-1]});
    }
};
