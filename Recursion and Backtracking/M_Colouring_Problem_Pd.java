/*

Date : 19th July 2025
Problem Link : https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

*/

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        
        int[] color = new int[v];
        
        //create the graph 
        List<List<Integer>> neighbours = new ArrayList<>();
        for (int i = 0; i < v; i++) neighbours.add(new ArrayList<>());
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            neighbours.get(from).add(to);
            neighbours.get(to).add(from);
        }
        
        
        return dfs(0,v,m,color,neighbours);
    }
    
    private boolean dfs(int currNode, int v, int m, int[] color, List<List<Integer>> neighbours) {
        if (currNode == v) return true;

        // Try all possible 'm' colors and return true if the combination is valid
        for (int currColor = 1; currColor <= m; currColor++) {
            if (isPossible(currNode, currColor, color, neighbours)) {
                color[currNode] = currColor;
                if (dfs(currNode + 1, v, m, color, neighbours)) return true;
                color[currNode] = 0;
            }
        }
        return false;
    }
    
    private boolean isPossible(int currNode,int currColor,int[] color,List<List<Integer>> neighbours){
        /*Traverse through the Adjacent nodes 
        and check if the currColor is Possible*/
        List<Integer> list = neighbours.get(currNode);
        for(int adjNode : list ){
            if(currColor == color[adjNode]) return false;
        }
        return true;
    }
}