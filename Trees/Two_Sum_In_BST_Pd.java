/*

Problem Link : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
Date : 23rd August 2025

 */

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
       
        if(root==null) return false;
        int val = root.val;
        int targetNeeded = k - val;
        if(set.contains(targetNeeded)) return true;
        set.add(val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}