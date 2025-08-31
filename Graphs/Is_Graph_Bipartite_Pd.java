/*

  Problem Link : https://leetcode.com/problems/is-graph-bipartite/
  Date : 27th August 2025

 */

class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] color = new int[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                //BFS
                //if(!isGraphBipartiteBFS(i,1,color,visited,graph)) return false;

                //DFS
                if(!isGraphBipartiteDFS(i,1,color,visited,graph)) return false;
            }
        }

        return true;
    }

    private boolean isGraphBipartiteBFS(int curr,int col,int[] color,boolean[] visited,int[][] graph){
        
         Queue<Integer> queue = new LinkedList<>();
         queue.offer(curr);
         color[curr]=col;
         visited[curr]=true;

        while(!queue.isEmpty()){

            int size = queue.size();
            col = col * -1;
            while(size-- > 0 ){
                int current = queue.poll();
                int[] neighbours = graph[current];

                for(int adj : neighbours){
                    if(!visited[adj]){
                        visited[adj]=true;
                        color[adj]=col;
                        queue.offer(adj);
                    }else if(visited[adj] && color[adj]==color[current]) 
                        return false;
                }

            }
        }
        return true;
    }

    private boolean isGraphBipartiteDFS(int curr,int currColor,int[] color,boolean[] visited,int[][] graph){

        color[curr]=currColor;
        visited[curr]=true;
        currColor=currColor*-1;
        
        int[] neighbours = graph[curr];
        for(int adjNode : neighbours){

            if(!visited[adjNode]){
                if(!isGraphBipartiteDFS(adjNode,currColor,color,visited,graph))  
                    return false;
            }else if(visited[adjNode] && color[adjNode]==color[curr]) 
                   return false;
        }

        return true;
      
    }
}