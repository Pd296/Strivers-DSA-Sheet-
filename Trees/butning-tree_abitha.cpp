Problem Link : https://www.geeksforgeeks.org/problems/burning-tree/1

/*
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution {
  public:
    int minTime(Node* root, int target) {
        // code here
        queue<Node*> q;
        unordered_map<Node*, Node*> parent;
        parent[root] = NULL;
        q.push(root);
        Node* tNode;
        while(!q.empty()) {
            Node* curr = q.front();
            q.pop();
            if(curr->data == target) {
                tNode = curr;
            }
            if(curr->left != NULL) {
                q.push(curr->left);
                parent[curr->left] = curr;
            }
            if(curr->right != NULL) {
                q.push(curr->right);
                parent[curr->right] = curr;
            }
        }
        
        int ans = 0;
        unordered_map<Node*, bool> visited;
        q.push(tNode);
        while(!q.empty()) {
            int size = q.size();
            while(size--) {
                Node* curr = q.front();
                q.pop();
                visited[curr] = true;
                if(curr->left != NULL && !visited[curr->left]) {
                    q.push(curr->left);
                }
                if(curr->right != NULL && !visited[curr->right]) {
                    q.push(curr->right);
                }
                if(parent[curr] != NULL && !visited[parent[curr]]) {
                    q.push(parent[curr]);
                }
            }
            
            ans++;
        }
        return ans-1;
        
        
    }
};




