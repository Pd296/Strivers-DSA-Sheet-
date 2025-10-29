/*

  Problem Link : https://leetcode.com/problems/course-schedule/description/
  Date : 31st August 2025 
  
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         
        // return canFinishBFS(numCourses,prerequisites); // BFS 
        return canFinishDFS(numCourses,prerequisites); // DFS
    }

    //solution using BFS
    private boolean canFinishBFS(int numCourses, int[][] prerequisites){
         
       List<List<Integer>> adj = new ArrayList<>();
       int[] indegree = new int[numCourses];
       for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

       for(int[] arr : prerequisites){

           int course = arr[0];
           int dependentCourse = arr[1];
           adj.get(course).add(dependentCourse);
           indegree[dependentCourse]++;
           
       }

       Queue<Integer> queue = new LinkedList<>();
       for(int i=0;i<numCourses;i++){
           if(indegree[i] == 0) queue.offer(i);
       }
       
       int count = 0;
       while(!queue.isEmpty()){
          
          int current = queue.poll();
          count += 1;
          List<Integer> neighbours = adj.get(current);

          for(int adjNode : neighbours){
               indegree[adjNode]--;
               if(indegree[adjNode] == 0) queue.offer(adjNode);
          }

       }

       return count == numCourses;
    }

    //Solution using DFS
    private boolean canFinishDFS(int numCourses,int[][] prerequisites){

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int[] arr : prerequisites){
           int course = arr[0];
           int dependentCourse = arr[1];
           adj.get(course).add(dependentCourse);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(checkCycleDFS(i,visited,pathVisited,adj)) return false;
            }
        }
       
       return true;
    }

    private boolean checkCycleDFS(int node,boolean[] visited,boolean[] pathVisited,List<List<Integer>> adj){

        visited[node] = true;
        pathVisited[node] = true;
        List<Integer> neighbours = adj.get(node);

        for(int adjNode : neighbours){
            if(!visited[adjNode]){
                 if(checkCycleDFS(adjNode,visited,pathVisited,adj)) return true;
            }else if(visited[adjNode] && pathVisited[adjNode]) return true; 
        }
          
        pathVisited[node] = false;
        return false;
        
    }
}