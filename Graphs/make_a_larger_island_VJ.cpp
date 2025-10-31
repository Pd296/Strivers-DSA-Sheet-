///Problem link: https://leetcode.com/problems/making-a-large-island/

class Solution {
public:
    int n;
    //direction array
    static constexpr int dir[4][2] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    vector<vector<int>> ref;
    int dfs(vector<vector<int>>& grid, vector<vector<int>>& visited, int i,
            int j, int island) {
        int count = 0;
        //explore all four directions
        for (auto& k : dir) {
            int x = k[0] + i;
            int y = k[1] + j;
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                if (visited[x][y] == 0) {
                    visited[x][y] = 1;
                    //coloring island
                    ref[x][y] = island;
                    count += dfs(grid, visited, x, y,island) + 1;
                }
            }
        }
        return count;
    }
    int largestIsland(vector<vector<int>>& grid) {
        int result = INT_MIN;
        n = grid.size();
        vector<vector<int>> visited(n, vector<int>(n, 0));
        vector<int> areas;
        areas.push_back(0);
        ref.resize(n, vector<int>(n, 0));
        int island = 0;
        //calculate available area before making changes and coloring island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    island++;
                    ref[i][j] = island;
                    int area = dfs(grid, visited, i, j, island) + 1;
                    areas.push_back(area);
                    result = max(area, result);
                }
            }
        }
        //exploring all possible flips from zero to one and calculating area
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    set<int> sp;
                    int area=1;
                    for (auto& k : dir) {
                        int x = k[0] + i;
                        int y = k[1] + j;
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                                if(sp.count(ref[x][y])==0){
                                sp.insert(ref[x][y]);
                                area+=areas[ref[x][y]];
                                }
                        }
                    }
                    result=max(area,result);
                }
            }
        }
        return result;
    }
};