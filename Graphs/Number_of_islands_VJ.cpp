class Solution {
  public:
  int m,n;
    int dfs(int i,int j,vector<vector<int>>& vis,vector<vector<char>>& grid){
         vector<vector<int>> dir={{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
         vis[i][j]=1;
         for(auto& k:dir){
             int x=k[0]+i,y=k[1]+j;
             if(x>=0 && y>=0 && x<n && y<m && vis[x][y]==0 && grid[x][y]=='L'){
                 dfs(x,y,vis,grid);
             }
         }
         return 0;
    }
    int countIslands(vector<vector<char>>& grid) {
        // Code here
        n=grid.size();
        m=grid[0].size();
        int count=0;
        vector<vector<int>>vis(n,vector<int>(m,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='L'){
                    count++;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return count;
    }
};
