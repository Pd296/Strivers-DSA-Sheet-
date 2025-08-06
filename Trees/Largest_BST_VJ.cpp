/* Tree node structure  used in the program

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};*/

class Solution {
  public:
    /*You are required to complete this method */
    // Return the size of the largest sub-tree which is also a BST
    int res;
    vector<int> dfs(Node* root){
        if(!root) return{1,0,INT_MAX,INT_MIN};
        
        auto l=dfs(root->left);
        auto r=dfs(root->right);
        int count=0;
        
       if(r[0]==1 && l[0]==1 && l[3] < root->data && root->data < r[2]){
           
           count=r[1]+l[1]+1;
           res=max(count,res);
           int lr=min(l[2],root->data);
           int rl=max(r[3],root->data);
           return {1,count,lr,rl};
       }else{
           return {0,0,0,0};
       }
       // cout<<cb<<" "<<count<<" "<<minc<<" "<<maxc<<"\n";
       
    }
    int largestBst(Node *root) {
        // Your code here
        res=0;
        dfs(root);
        return res;
    }
};
