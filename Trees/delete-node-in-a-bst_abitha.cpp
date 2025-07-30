Problem Link : https://leetcode.com/problems/delete-node-in-a-bst/description/

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
    int checkMinOnRightNode(TreeNode* root) {
        if (root == NULL) {
            return -1; 
        }
        while (root->left != NULL) {
            root = root->left;
        }
        return root->val;
    }
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == NULL) return NULL;
        if(root->val < key) {
            root->right = deleteNode(root->right, key);
            return root;
        }
        if(root->val > key) {
            root->left = deleteNode(root->left, key);
            return root;
        }
        //now we arrived the delete position
        //considering it has no childs
        if(root->left == NULL && root->right ==NULL) {
            return NULL;
        }
        //considering it has only one node
        if(root->left == NULL && root->right != NULL) {
            return root->right;
        }
        if(root->right == NULL && root->left != NULL) {
            return root->left;
        }
        //considering it have both childs
        int value = checkMinOnRightNode(root->right);
        root->val = value;
        root->right = deleteNode(root->right, value);
        return root;
    }
};
