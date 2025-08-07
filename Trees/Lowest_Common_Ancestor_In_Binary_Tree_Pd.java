/*

Problem Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
Date : 6th August 2025

 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null) return null ;

        //keep searching for P and Q and return then once they are found
        if(root==p || root == q) return root; 

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        // return the root as we found the LCA
        if(left != null && right != null ) return root;
        if(left == null && right == null ) return null;
        
        //return the not null node 
        return left != null ? left : right ;

    }
}