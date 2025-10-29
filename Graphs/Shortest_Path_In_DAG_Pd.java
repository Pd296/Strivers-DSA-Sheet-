/*

  Problem Link : https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
  Date : 1st September 2025

 */

class Point{
    int node;
    int weight;
    Point(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<Point>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        //create the adj list
        for(int[] arr : edges ){
            
            int from = arr[0];
            int to = arr[1];
            int weight = arr[2];
            
            Point point = new Point(to,weight);
            adj.get(from).add(point);
        }
        
        //initialize the distance array to Max value
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);

        // Start regular BFS
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0));
        distance[0]=0;
        
        while(!queue.isEmpty()){
            
            Point current = queue.poll();
            int currNode = current.node;
            int currDistance = current.weight;
            
            List<Point> neighbours = adj.get(currNode);
            for(Point adjPoint : neighbours){
                
                int adjNode = adjPoint.node;
                int distanceToReachAdjNode = adjPoint.weight;

                // Calculate the new distance to reach the adjNode
                int newDistance = currDistance + distanceToReachAdjNode;

                //if the new distance is greater , skip it
                if(distance[adjNode] <= newDistance) continue;
                //if the new distance is shorter, update the distance and enqueue the adjNode
                distance[adjNode] = newDistance;
                queue.offer(new Point(adjNode,newDistance));
                
            }
        }

        //if any node is unreachable, mark it as -1
        for(int i=0;i<V;i++){
            if(distance[i] == Integer.MAX_VALUE) distance[i]=-1;
        }
        
        return distance;
    }
}