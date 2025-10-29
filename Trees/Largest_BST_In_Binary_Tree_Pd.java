/*

Problem Link : https://www.geeksforgeeks.org/problems/largest-bst/1
Date : 23rd August 2025

 */

class Point{
         int maxSize;
         int minValue;
         int maxValue;
        
        Point(int maxSize,int minValue,int maxValue){
            this.maxSize=maxSize;
            this.minValue=minValue;
            this.maxValue=maxValue;
        }
}
class Solution {
    
      static Point largestBstSubtree(Node root){
        if(root==null) return new Point(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        
        Point leftTree = largestBstSubtree(root.left);
        Point rightTree = largestBstSubtree(root.right);
        
        //if it is a valid BST
        if(root.data > leftTree.maxValue && root.data < rightTree.minValue){
            int maxSize=leftTree.maxSize+rightTree.maxSize+1;
            int minValue=Math.min(root.data,leftTree.minValue);
            int maxValue=Math.max(root.data,rightTree.maxValue);
            return new Point(maxSize,minValue,maxValue);
        }
        
         // not a BST → carry forward largest valid BST size found so far
        return new Point(Math.max(leftTree.maxSize,rightTree.maxSize),Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    
    // Return the size of the largest sub-tree which is also a BST
    public static int largestBst(Node root) {
        return largestBstSubtree(root).maxSize;
    }
}