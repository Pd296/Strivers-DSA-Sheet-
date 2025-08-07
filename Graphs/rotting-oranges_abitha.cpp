// Problem lINk : https://leetcode.com/problems/rotting-oranges/description/

class Solution {
public:
    bool checkAll(vector<vector<bool>> visited, int rows, int cols, vector<vector<int>> grid) {
        for(int i = 0;i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(!visited[i][j] && grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    int orangesRotting(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        int ans = 0;
        queue<pair<int, int>> q;
        if(checkAll(visited, rows, cols, grid)) {
                return 0;
        }
        for(int i = 0;i < rows;i++) {
            for(int j = 0;j < cols;j++) {
                if(grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.push({i, j});
                }
            }
        }
        while(!q.empty()) {
            int cnt = q.size();
            int inserted = 0;
            while(cnt--) {
                pair<int, int> front = q.front();
                int vr = front.first;
                int vc = front.second;
                q.pop(); //remove the pair from queue
                // now we got visited row and column, we have to check adj and mark remaining
                //right => x+1, y
                if(vr+1 < rows && !visited[vr+1][vc] && grid[vr+1][vc] != 0) {
                    inserted = 1;
                    visited[vr+1][vc] = true;
                    q.push({vr+1, vc});
                }
                //left => x-1, y
                if(vr-1 >= 0 && !visited[vr-1][vc] && grid[vr-1][vc] != 0) {
                    inserted = 1;
                    visited[vr-1][vc] = true;
                    q.push({vr-1, vc});
                }
                //up => x, y+1
                if(vc+1 < cols && !visited[vr][vc+1] && grid[vr][vc+1] != 0) {
                    inserted = 1;
                    visited[vr][vc+1] = true;
                    q.push({vr, vc+1});
                }
                //down => x, y-1
                if(vc-1 >= 0 && !visited[vr][vc-1] &&  grid[vr][vc-1] != 0) {
                    inserted = 1;
                    visited[vr][vc-1] = true;
                    q.push({vr, vc-1});
                }

            }
            if(inserted) {
                ans++;
            }
            if(checkAll(visited, rows, cols, grid)) {
                return ans;
            }
        }
        return -1;

    }
};
