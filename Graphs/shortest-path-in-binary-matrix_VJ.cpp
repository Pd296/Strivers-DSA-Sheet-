//Problem link: https://leetcode.com/problems/shortest-path-in-binary-matrix/



using tiii=tuple<int,int,int>;
class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n=grid.size();
        vector<vector<int>> dir ={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}}; //8 directional direction
        
        queue<tiii> q; //queue for BFS as {cost,i,j};
        q.emplace(1,0,0);
        if(grid[0][0]==1)return -1;
        //BFS
        while(!q.empty()){
            auto [cost,i,j]=q.front();
            q.pop();
            if(i==n-1 && j==n-1){
                return cost;
            }
            for(auto& k: dir){
                int x=k[0]+i;
                int y=k[1]+j;
                if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==0 ){
                    grid[x][y]=1;
                    q.emplace(cost+1,x,y);
                }
            }
        }
        return -1;
    }
};

/* 
Time complexity : O(N^2)
Space complexity: O(N^2)
*/