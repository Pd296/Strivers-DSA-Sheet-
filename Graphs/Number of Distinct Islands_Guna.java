
//link-https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1

// User function Template for Java

class Solution {
    
    void bfs(int r,int c,int[][] grid,int[][] vis,HashSet<ArrayList<String>> ans){
        int n_rows=grid.length;
        int n_cols=grid[0].length;
        int[] dx=new int[]{0,0,1,-1};
        int[] dy=new int[]{-1,1,0,0};
        Queue<int[]> q=new LinkedList<>();
        ArrayList<String> list=new ArrayList<>();
        int[] pos=new int[]{r,c};
        q.offer(pos);
        while(!q.isEmpty()){
            int[] cur=q.poll();
            list.add((r-cur[0])+" "+(c-cur[1]));
            for(int i=0;i<4;i++){
                int new_r=cur[0]+dx[i];
                int new_c=cur[1]+dy[i];
                if(new_r>=0 && new_r<n_rows && new_c>=0 && new_c<n_cols && vis[new_r][new_c]==0 && grid[new_r][new_c]==1){
                    vis[new_r][new_c]=1;
                    q.offer(new int[]{new_r,new_c});
                    
                }
            }
        }
        ans.add(list);
        return;
        
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<ArrayList<String>> ans=new HashSet<>();
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] vis=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    bfs(i,j,grid,vis,ans);
                }
            }
        }
        return ans.size();
    }
}
