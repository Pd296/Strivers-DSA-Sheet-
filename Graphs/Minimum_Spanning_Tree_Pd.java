/*

  Problem Link : https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
  Date : 4th October 2025

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
    public int spanningTree(int V, int[][] edges) {
        // code here
        
        boolean[] visited = new boolean[V];
        //create the adj list
        List<List<Point>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        for(int[] arr : edges ){
            
            int from = arr[0];
            int to = arr[1];
            int wt = arr[2];
            
            adj.get(from).add(new Point(to,wt));
            adj.get(to).add(new Point(from,wt));
        }
        
        //start with node 0
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.offer(new Point(0,0));
        
        int minimumSpanningWeight = 0;
        
        while(!pq.isEmpty()){
            
            Point current = pq.poll();
            int currNode = current.node;
            int currWt = current.weight;
            
            if(visited[currNode]) continue;
            visited[currNode]=true;
            minimumSpanningWeight += currWt;
            
            List<Point> neighbours = adj.get(currNode);
            for(Point neighbour : neighbours ){
                
                int cost = neighbour.weight;
                int neighbouringNode = neighbour.node;
                if(visited[neighbouringNode]) continue;
                
                pq.offer(new Point(neighbouringNode,cost));
            }
        }
        
        return minimumSpanningWeight;
    }
}
