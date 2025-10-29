/* 

  Problem Link : https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
  Date : 1st September 2025

 */

class Point{
    int node;
    int distanceSoFar;
    Point(int node,int distanceSoFar){
        this.node=node;
        this.distanceSoFar=distanceSoFar;
    }
}
class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here

        int n = adj.size();

        //initialize the distance array to Max Value
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        //Start regular BFS
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(src,0));
        distance[src]=0;
        
        while(!queue.isEmpty()){
            
            Point current = queue.poll();
            int currNode = current.node;
            int currDistance = current.distanceSoFar;
            int distanceToReachNeighbours = currDistance + 1;
            
            List<Integer> neighbours = adj.get(currNode);
            for(int adjNode : neighbours ){
                
                if(distance[adjNode] <= distanceToReachNeighbours) continue;
                distance[adjNode] = distanceToReachNeighbours;
                queue.offer(new Point(adjNode,distanceToReachNeighbours));
            }
        }
        //if any node is unreachable, mark it as -1
        for(int i=0;i<n;i++){
            if(distance[i] == Integer.MAX_VALUE) distance[i]=-1;
        }
        
        return distance;
    }
}
