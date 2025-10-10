//problem : https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int[] row={-1, 1, 0, 0, 1, 1, -1, -1};
        int[] col={0, 0, -1, 1, 1, -1, 1, -1};
        int islandCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L' && visited[i][j]==0){
                    bfs(grid,visited,i,j,row,col,n,m);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    private void bfs(char[][] grid,int[][] visited,int i,int j,int[] row,int[] col,int n,int m){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j]=1;
        while(!queue.isEmpty()){
            int[] val=queue.poll();
            int r=val[0];
            int c=val[1];
            for(int k=0;k<8;k++){
                int newRow=r+row[k];
                int newCol=c+col[k];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]=='L' && visited[newRow][newCol]==0){
                    visited[newRow][newCol]=1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}