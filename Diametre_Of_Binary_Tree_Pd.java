/*

Problem Link : https://leetcode.com/problems/diameter-of-binary-tree/
Date : 30th July 2025

 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
       if(root==null) return 0;
       int currDiametre = maxDepth(root.left) + maxDepth(root.right);

       int left_diametre=diameterOfBinaryTree(root.left);
       int right_diametre=diameterOfBinaryTree(root.right);

       return Math.max(currDiametre,Math.max(left_diametre,right_diametre));
    }

    private int maxDepth(TreeNode root){

        if(root==null) return 0;
        int leftHeight = 1 + maxDepth(root.left);
        int rightHeight = 1 + maxDepth(root.right);

        return Math.max(leftHeight,rightHeight);
    }
}