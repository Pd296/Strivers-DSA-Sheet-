class Solution {
public:
    int m,n;
    const int dir[4][2]={{1,0},{-1,0},{0,1},{0,-1}};
    int dfs(vector<vector<int>>& grid,vector<vector<int>>& vis,int i,int j,int re){
        int res= re,k=grid[i][j];
        grid[i][j]='0';
        for(auto& k: dir){
            int x=i+k[0],y=j+k[1];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                vis[x][y]=min(vis[x][y],re+1);
                int cur= dfs(grid,vis,x,y,re+1);
                res=max(res,cur);
            }
        }
        grid[i][j]=k;
        return 0;
    }
    int orangesRotting(vector<vector<int>>& grid) {
        int res=0;
        m=grid.size();
        n=grid[0].size();
        vector<vector<int>>vis(m,vector<int>(n,INT_MAX));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    dfs(grid,vis,i,j,0);
                }
            }
        }
         int res1=INT_MIN;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=INT_MAX)
                  res1=max(res1,vis[i][j]);
                if(vis[i][j]==INT_MAX && grid[i][j]==1)
                return -1;
            }
        }
        return res1==INT_MIN?0:res1;
    }
};
