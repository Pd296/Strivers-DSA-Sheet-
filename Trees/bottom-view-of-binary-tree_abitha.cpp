// Problem Link : https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
/*
struct Node
{
    int data;
    Node* left;
    Node* right;
};
*/

class Solution {
  public:
    vector<int> bottomView(Node *root) {
        // Your Code Here
        vector<int> ans;
        unordered_map<int, int> mp;
        queue<pair<Node*, int>> q;
        q.push({root,0});
        // mp[0] = root->data;
        //insert root in mp, q
        int mini = INT_MAX;
        int maxi = INT_MIN;
        while(!q.empty()) {
            Node* curr = q.front().first;
            int level = q.front().second;
            mini = min(mini, level);
            maxi = max(maxi, level);
            mp[level] = curr->data;
            q.pop();
            if(curr->left != NULL) {
                q.push({curr->left, level-1}); //insert left one
            }
            if(curr->right != NULL) {
                q.push({curr->right, level+1});
            }
        }
        for(int i = mini;i <= maxi;i++) {
            ans.push_back(mp[i]);
        }
        return ans;
    }
};

