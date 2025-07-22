
//date 22-jul-2025
//link-https://leetcode.com/problems/binary-tree-maximum-path-sum/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max_sum=Integer.MIN_VALUE;
    int tree(TreeNode root){
        if(root==null) return 0;
        int left=tree(root.left);
        int right=tree(root.right);
        max_sum=Math.max(max_sum,root.val+left+right);

        return Math.max(0,root.val+Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
        tree(root);
        return max_sum;
    }
}