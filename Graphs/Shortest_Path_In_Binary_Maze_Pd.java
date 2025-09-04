/*

  Problem Link : https://leetcode.com/problems/shortest-path-in-binary-matrix/
  Date : 2nd September 2025

 */

class Point{
    int r;
    int c;
    int distanceSoFar;
    Point(int r,int c,int distanceSoFar){
        this.r=r;
        this.c=c;
        this.distanceSoFar=distanceSoFar;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        //check for unreachable end points
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1 ) return -1;

        //priority queue on distance
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.distanceSoFar-b.distanceSoFar);

        pq.offer(new Point(0,0,1));
       
        int[][] directions = {{-1, 0}, // up
                        {1, 0},  // down
                        {0, -1}, // left
                        {0, 1},  // right
                        {-1, -1}, // up-left
                        {-1, 1},  // up-right
                        {1, -1},  // down-left
                        {1, 1}    // down-right
                        };

        //regular BFS
        while(!pq.isEmpty()){

              Point current = pq.poll();
              int r = current.r;
              int c = current.c;
              int distance = current.distanceSoFar;

              //end point reached
              if(r == n-1 && c==n-1) return distance;

              //traverse all 8 directions
              for(int[] dir : directions){

                     int new_r = r+dir[0];
                     int new_c = c+dir[1];
                     
                //check for valid cell
                 if(new_r >=0 && new_r < n && new_c >= 0 && new_c < n && grid[new_r][new_c] == 0){
                    pq.offer(new Point(new_r,new_c,distance+1));
                    grid[new_r][new_c] = 1; // mark the cell as visited or blocked
                 }

              }
        }

        //return -1 if no path found
        return -1;

    }
}