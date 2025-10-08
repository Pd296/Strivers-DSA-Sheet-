/*
 
  Problem link : https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
  Date : 10th September 2025

 */

class Point{
    int node;
    int steps;
    Point(int node,int steps){
        this.node=node;
        this.steps=steps;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int n = arr.length;
        int mod = 100000;
        Set<Integer> visitedSet = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();

        //BFS 
        queue.offer(new Point(start,0));
        visitedSet.add(start);
        
        while(!queue.isEmpty()){
            
            Point current = queue.poll();
            int currNode = current.node;
            int currSteps = current.steps;
            
            if(currNode == end ) return currSteps;
            
            for(int num : arr){
                
                int newNumber = (int)(((long)currNode * num) % mod); 
                if(!visitedSet.contains(newNumber)){
                    queue.offer(new Point(newNumber,currSteps+1));
                    visitedSet.add(newNumber);
                }
            }
        }
        return -1; // If we exhaust all possibilities
    }
}
