// Problem Link : https://leetcode.com/problems/binary-tree-maximum-path-sum

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int findMaxPath(TreeNode*root, int& res) {
        if(root == NULL) return 0;
        int lsum = findMaxPath(root->left, res);
        int rsum = findMaxPath(root->right, res);
        res = max(res, root->val + lsum + rsum);
        return root->val + lsum + rsum;
    }
    int maxPathSum(TreeNode* root) {
        int res = 0;
        findMaxPath(root, res);
        return res;
    }
};
