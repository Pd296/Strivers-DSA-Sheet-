/*

  Problem Link : https://leetcode.com/problems/find-eventual-safe-states/description/
  Date : 31st August 2025

 */

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        /*

        We reverse the graph because , it is easier to find 
        the safe terminal nodes and propogate backwards from 
        them as we have the connection from terminal nodes to their parents 
        instead of other way 

        */

        //create the reversed graph 
        for(int i=0;i<n;i++){
            int sourceNode = i;
            int[] destinationNodes = graph[i];
            for(int dest : destinationNodes){
                adj.get(dest).add(sourceNode);
                indegree[sourceNode]++;
            }            
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0) queue.offer(i);
        }
  
        //topo sort
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            List<Integer> neighbours = adj.get(node);
            for(int adjNode : neighbours){
                  indegree[adjNode]--;
                  if(indegree[adjNode] == 0 ) queue.offer(adjNode);
            }
        }

        //sort and return the result
        Collections.sort(result);
        return result;
    }
}