/*

Problem Link : https://practice.geeksforgeeks.org/problems/burning-tree/1
Date : 7th August 2025

 */

class Solution {
    static class Point{
        Node parent;
        Node current;
        Point(Node current,Node parent){
            this.parent=parent;
            this.current=current;
        }
        
    }
    public static int minTime(Node root, int target) {
        // code here
         HashMap<Node,Node> map = new HashMap<>();
         findParent(root,map);
         Node targetNode = findNode(root,target);
         Set<Node> visited = new HashSet<>();
         
         Queue<Node> queue = new LinkedList<>();
         queue.add(targetNode);
         int time = 0 ;
         
        while(!queue.isEmpty()){
             
          int size = queue.size();
          boolean spread = false;

          for (int i = 0; i < size; i++) {
              Node curr = queue.poll();
              visited.add(curr);

              for (Node neighbor : Arrays.asList(curr.left, curr.right, map.get(curr))) {
                 if (neighbor != null && !visited.contains(neighbor)) {
                     queue.add(neighbor);
                     visited.add(neighbor);
                     spread = true;
                  }
              }
          }

           if (spread) time++; // only increment if fire spread in this level
        }
         
         return time;
         
       
    }
    
    private static Node findNode(Node root, int target){
        
        if(root==null) return null;
        if(root.data == target) return root;
        
        Node left =  findNode(root.left,target);
        Node right = findNode(root.right,target);
        if(left == null && right == null ) return null;
        
        
        return left != null ? left : right ;
    }
    private static void  findParent(Node root,HashMap<Node,Node> map){
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(root,null));
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            Point point = queue.poll();
            Node currentNode = point.current;
            Node parentNode = point.parent;
            //int currentVal = point.current.data;
            //int parentVal = point.parent == null ? -1 :  point.parent.data;
            map.put(currentNode,parentNode);
        
            if(currentNode.left != null ) queue.add(new Point(currentNode.left,currentNode));
            if(currentNode.right != null ) queue.add(new Point(currentNode.right,currentNode));
  
        }
        
        //System.out.println(map);
        return;
    }
}