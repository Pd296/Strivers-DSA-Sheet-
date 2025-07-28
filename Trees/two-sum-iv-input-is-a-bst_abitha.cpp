// Problem Link : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
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
    void inorder(TreeNode* root, vector<int>& res) {
        if(root == NULL) {return;}
        inorder(root->left,res);
        res.push_back(root->val);
        // cout<< root->val << "\n";
        inorder(root->right,res);
    }
    bool check(vector<int> res, int ele, int i) {
        int n = res.size();
        int lo = 0;
        int hi = n-1;
        
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(res[mid] == ele) {
                if(mid == i) return false;
                return true;
            }
            else if(res[mid] < ele) {
                lo = mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return false;
    }
    bool findTarget(TreeNode* root, int k) {
        vector<int> res;
        inorder(root, res);
        int n = res.size();
        for(int i = 0;i < n;i++) {
            if(check(res, k-res[i], i)) {
                return true;
            }
        }
        return false;
        
    }
};
