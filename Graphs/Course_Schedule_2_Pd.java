/*

  Problem Link : https://leetcode.com/problems/course-schedule-ii/
  Date : 27th August 2025

 */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        //create the adj list and indegree array
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int[] arr : prerequisites){
            int from = arr[0];
            int to = arr[1];
            indegree[to]++;
            adj.get(from).add(to);
        }


       //enqueue all nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        
        //BFS 
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){

            int current = queue.poll();
            stack.push(current);
            List<Integer> neighbours = adj.get(current);

            for(int adjNode : neighbours){
                indegree[adjNode]--;
                if(indegree[adjNode]==0)queue.offer(adjNode);
            }

        }

        //Check if topological sort is possible 
        if(stack.size() < numCourses) return new int[]{};

        //store and return the result
        int[] result = new int[numCourses];
        int i=0;
        while(!stack.isEmpty()){
            result[i]=stack.pop();
            i+=1;
        }

        return result;
    }
}