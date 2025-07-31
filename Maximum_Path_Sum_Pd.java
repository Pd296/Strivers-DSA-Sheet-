/*

Problem Link : https://leetcode.com/problems/binary-tree-maximum-path-sum/
Date : 31st July 2025
 */


class Solution {

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         maxGain(root);
         return maxSum;
    }

    private int maxGain(TreeNode root){
     if (root == null) return 0;

        // only take positive contributions
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);

        // path including both children + root
        int priceNewPath = root.val + left + right;

        // update global max if needed
        maxSum = Math.max(maxSum, priceNewPath);

        return root.val + Math.max(left, right);
    }
}