/**
 Problem Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 Date : 23rd August 2025
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
         if(root==null)return null;
        if(root.val < p.val && root.val >q.val || root.val > p.val && root.val < q.val) return root;
        if(root.val <p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        return root;
        
    }
}