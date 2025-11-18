//problem: https://leetcode.com/problems/rotting-oranges/description/

class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> queue=new LinkedList<>();
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) queue.add(new Pair(i,j,0));
            }
        }
        int ans=0;
        int dir_row[]={-1,0,1,0};
        int dir_col[]={0,-1,0,1};
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            int row=p.row;
            int col=p.col;
            int time=p.time;
            ans=time;
            for(int i=0;i<4;i++){
                int r=row+dir_row[i];
                int c=col+dir_col[i];
                if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                    queue.add(new Pair(r,c,time+1));
                    grid[r][c]=2;
                } 
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1;
            } 
        }
        return ans;
    }
}

class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}