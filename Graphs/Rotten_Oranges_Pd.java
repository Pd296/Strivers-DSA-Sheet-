/*

   Problem Link : https://leetcode.com/problems/rotting-oranges/
   Date : 24th August 2025

 */

class Point{
    int r;
    int c;

    Point(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n=grid[0].length;

        //add all the rotten oranges to queue
        Queue<Point> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) queue.add(new Point(i,j));
            }
        }

        //direction array for 4 directions
        int[] dir = new int[]{-1,0,1,0,-1};

        int time = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            boolean rotted = false;
            while(size-- > 0){

                Point current = queue.poll();
                int row = current.r;
                int col = current.c;

                //traverse 4 directions
                for(int k=0;k<4;k++){

                    int new_row = row + dir[k];
                    int new_col = col + dir[k+1];

                    //check for out of bounds
                    if(new_row >=m || new_row < 0 || new_col < 0 || new_col >= n)
                            continue;

                     if(grid[new_row][new_col] == 1){
                        queue.add(new Point(new_row,new_col));
                        grid[new_row][new_col]=2;
                        rotted=true;
                     }
                     
                }
            }
            //only increment the time if new oranges were rotted
            if(rotted) time += 1;
        }

        //check for fresh oranges and return -1 if found
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }

        return time;
    }
}