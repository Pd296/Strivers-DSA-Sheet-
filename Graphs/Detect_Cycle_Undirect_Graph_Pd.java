/*

 * Problem Link : https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * Date : 25th August 2025
 * 
 */
class Point{
    
    int parent;
    int node;
    
    Point(int node, int parent){
        this.node=node;
        this.parent=parent;
    }
}

class Solution {
    
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        boolean[] visited = new boolean[V];
        
        //prepare the graph
        for(int[] edge: edges){
            
            int from = edge[0];
            int to = edge[1];
            //undirected 
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        
    
        for(int i=0;i<V;i++){
            if(!visited[i]){
                //if(detectCycleBFS(i,adj,visited))return true; BFS
                if(detectCycleDFS(i,-1,adj,visited)) return true; // DFS
            }
        }
        
        return false;
       
    }
    
    private boolean detectCycleBFS(int src,List<List<Integer>> adj,boolean[] visited){
         
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(src,-1));
        visited[src]=true;
        
        while(!queue.isEmpty()){
            
            Point current = queue.poll();
            int node = current.node;
            int parent = current.parent;
               
            List<Integer> neighbours = adj.get(node);
            for(int ele : neighbours){
                    
                if(visited[ele] && ele!=parent) return true;
                if(!visited[ele]){
                    visited[ele]=true;
                    queue.offer(new Point(ele,node));
                }
            }
        }
        
        return false;
        
    }
    
    private boolean detectCycleDFS(int src,int parent,List<List<Integer>> adj,boolean[] visited){
        
        visited[src]=true;
        List<Integer> neighbours = adj.get(src);
        
        for(int adjNode : neighbours){
            
            if(!visited[adjNode]){
                if(detectCycleDFS(adjNode,src,adj,visited)) return true;
            }else if(visited[adjNode] && adjNode != parent)
                return true;
        }
        
        return false;
    }
}