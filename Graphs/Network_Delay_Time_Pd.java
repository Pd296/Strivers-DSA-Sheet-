/*

 Problem Link : https://leetcode.com/problems/network-delay-time/description/
 Date : 4th September 2025
*/

class Point{
    int node;
    int time;
    Point(int node,int time){
        this.node=node;
        this.time=time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        
        List<List<Point>> adj = new ArrayList<>();
        int[] timeArray = new int[n+1]; 
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        Arrays.fill(timeArray,Integer.MAX_VALUE);

        

        //create the adj list
        for(int[] arr : times ){

            int from = arr[0];
            int to = arr[1];
            int timeTaken = arr[2];

            Point point = new Point(to,timeTaken);
            adj.get(from).add(point);
        }

        //Dijkstra's Algorithm
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.time-b.time);
        pq.offer(new Point(k,0));
        timeArray[k]=0;

        while(!pq.isEmpty()){

            Point current = pq.poll();
            int currNode = current.node;
            int time = current.time;

            //Skip outdated entries
            if (time > timeArray[currNode]) continue;
            
            List<Point> neighbours = adj.get(currNode);
            for(Point neighbour : neighbours){

                int adjNode = neighbour.node;
                int timeTakenToReachAdjNode = neighbour.time;

                int totalTime = time + timeTakenToReachAdjNode;

                if(totalTime < timeArray[adjNode]){
                    timeArray[adjNode] = totalTime;
                    pq.offer(new Point(adjNode,totalTime));
                }
            }
        }

        //Find the maximum time taken to reach any node
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            if(timeArray[i] == Integer.MAX_VALUE) return -1; // return -1 if any node is unreachable
            max = Math.max(timeArray[i],max);
        }

        return max;

    }
}