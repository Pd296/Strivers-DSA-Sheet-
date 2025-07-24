// Problem Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isPresent(TreeNode* root, TreeNode* ch) {
        
        if (root == nullptr) return false;
        if (root == ch) return true;
        return isPresent(root->left, ch) || isPresent(root->right, ch);
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == p || root == q) {
            return root;
        }
        else if(isPresent(root->left, p) && isPresent(root->left, q)) {
            return lowestCommonAncestor(root->left, p, q);
        }
        else if(isPresent(root->right, p) && isPresent(root->right,q)) {
            return lowestCommonAncestor(root->right, p, q);
        }
        else{
            return root;
        }
        return root;
    }
};
