Problem Link : https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
class Solution {
  public:
    void DFS(vector<vector<char>>& grid, int row, int col) {
        int r = grid.size();
        int c = grid[0].size();
        if(row < 0 || col < 0 || row >= r || col >= c || grid[row][col] == 'W') {
            return;
        }
        grid[row][col] = 'W';
        vector<int> f = {1, -1, 0, 0, 1, -1, 1, -1};
        vector<int> s = {0, 0, 1, -1, 1, -1, -1, 1};
        for(int i = 0;i < 8;i++) {
            DFS(grid, row+f[i], col+s[i]);
        }
        
    }
    int countIslands(vector<vector<char>>& grid) {
        // Code here
        int rows = grid.size();
        int cols = grid[0].size();
        int cnt = 0;
        for(int i = 0;i < rows;i++) {
            for(int j = 0;j < cols;j++) {
                if(grid[i][j] == 'L') {
                    cnt++;
                    DFS(grid, i, j);
                }
            }
        }
        return cnt;
    }
};

//o(row*col), o(1)
