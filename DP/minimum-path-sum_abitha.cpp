Problem Link : https://leetcode.com/problems/minimum-path-sum/

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int r = grid.size();
        int c = grid[0].size();
        for(int i = 0;i < r; i++) {
            for(int j = 0;j < c;j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0) { //it can come only from left
                    grid[i][j] = grid[i][j-1];
                } 
                else if(j == 0) {
                    grid[i][j] = grid[i-1][j];
                }
                else{
                    grid[i][j] += min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[r-1][c-1];
    }
};


