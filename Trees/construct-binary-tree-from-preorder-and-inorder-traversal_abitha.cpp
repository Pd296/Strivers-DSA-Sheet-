// Problem Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
    int idx = 0;
    int findEle(vector<int>& inorder, int ele) {
        for(int i = 0;i < inorder.size();i++) {
            if(inorder[i] == ele) {
                return i;
            }
        }
        return -1;
    }
    TreeNode* construct(vector<int>& preorder, vector<int>& inorder, int lo, int hi) {
        if(lo > hi) return NULL;
        int curr = preorder[idx++];
        int cindx = findEle(inorder,curr);
        TreeNode* n = new TreeNode(curr);
        n->left = construct(preorder, inorder, lo, cindx-1);
        n->right = construct(preorder, inorder, cindx+1, hi);
        return n;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return construct(preorder, inorder, 0,inorder.size()-1);
    }
};
