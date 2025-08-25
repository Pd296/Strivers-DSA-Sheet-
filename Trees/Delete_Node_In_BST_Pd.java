/*
 Problem Link : https://leetcode.com/problems/delete-node-in-a-bst/
 Date : 23rd August 2025
 */

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null) return null;
        if(root.val == key ) return helper(root);

        TreeNode dummyRoot = root;
        while(root != null){
            //traverse left
            if(root.val > key){
               if(root.left !=null && root.left.val==key){
                    root.left=helper(root.left);
                    break;
               }else{
                    root=root.left;
               }
            //traverse right
            }else{
               if(root.right !=null && root.right.val==key){
                  root.right = helper(root.right);
                  break;
               }else{
                  root=root.right;
               }
            }
        }
        return dummyRoot;
    }

    private TreeNode helper(TreeNode root){
        
        // attach directly if one child is missing
        if(root.left == null) return root.right;
        else if (root.right == null ) return root.left;

        //attach the right child to the last right node of the left child
        //  and then return the left child
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right=rightChild;
        return root.left;
    }

    private TreeNode findLastRight(TreeNode root){
        if(root.right == null) return root;
        return findLastRight(root.right);
    }
}