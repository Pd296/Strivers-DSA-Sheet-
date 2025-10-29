/*

  Problem Link : https://leetcode.com/problems/01-matrix/description/
  Date : 26th August 2025

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
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] distance = new int[m][n];
        Queue<Point> queue = new LinkedList<>();

        // Initialize the queue with all the 0's positions and mark them visited .
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.add(new Point(i,j));
                    distance[i][j]=0;
                    visited[i][j]=true;
                }
            }
        }

        // direction array for 4 directions
        int[] dir = new int[]{-1,0,1,0,-1};

        while(!queue.isEmpty()){

            int size = queue.size();
            while(size-- > 0 ){

                Point current = queue.poll();
                int row = current.r;
                int col = current.c;

                //traverse 4 directions
                for(int i=0;i<4;i++){

                    int new_row = row + dir[i];
                    int new_col = col + dir[i+1];

                    //boundary condition or node already visited 
                    if(new_row < 0 || new_row >=m || new_col < 0 || new_col >=n || visited[new_row][new_col])
                         continue;
                    
                    //increment the distance, mark them visited and add to queue
                    distance[new_row][new_col]=distance[row][col]+1;
                    visited[new_row][new_col]=true;
                    queue.add(new Point(new_row,new_col));

                }
            } 
        }

        return distance;
    }
}