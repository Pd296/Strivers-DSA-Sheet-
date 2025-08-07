/*

Problem Link :  https://www.geeksforgeeks.org/bottom-view-binary-tree/
Date : 2nd August 2025

 */


class Solution {
    
    class Point{
        Node node;
        int level;
        Point(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        TreeMap<Integer,Integer> map = new TreeMap<>(); // sorts automatically based on key
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(new Point(root,0));
        
        while(!queue.isEmpty()){
            
          Point currentPoint = queue.poll();
          Node currentNode = currentPoint.node;
          int currentLevel = currentPoint.level;
          int currentValue = currentNode.data;
          map.put(currentLevel,currentValue);
          if(currentNode.left!=null)queue.add(new Point(currentNode.left,currentLevel-1));
          if(currentNode.right!=null)queue.add(new Point(currentNode.right,currentLevel+1));
          
        }
        
        
       // System.out.println(map);
        map.forEach((key,value)->{
            result.add(value);
        });
        
        return result;
        
    }
}