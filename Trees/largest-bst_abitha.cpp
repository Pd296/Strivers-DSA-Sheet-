Problem Link : https://www.geeksforgeeks.org/problems/largest-bst/1

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

class NodeValue{
    public:
        int maxNode, minNode, size;
        
        NodeValue(int minNode, int maxNode, int size) {
            this->minNode = minNode;
            this->maxNode = maxNode;
            this->size = size;
        }
};
class Solution {
  public:
    NodeValue BST(Node* root) {
        if(!root) {
            return NodeValue(INT_MAX, INT_MIN, 0);
            // this is for left and right of leaf nodes to satisfy max < root val and root val > min we changed min and max
        }
        
        NodeValue left = BST(root->left);
        NodeValue right = BST(root->right);
        
        if(left.maxNode < root->data && root->data < right.minNode) {
            //if it is BST
            return NodeValue(min(root->data, left.minNode), max(root->data, right.maxNode), left.size+right.size+1);
        }
        
        return NodeValue(INT_MIN, INT_MAX, max(left.size, right.size)); //if this is not BST all ancestors which forms eith this is also not BST
    }
    /*You are required to complete this method */
    // Return the size of the largest sub-tree which is also a BST
    int largestBst(Node *root) {
        // Your code here
        return BST(root).size;
        
    }
};
