/*

Problem Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Date : 8th August 2025

 */
 
class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            return createTree(preorder,inorder,0,n-1);
    }
    private TreeNode createTree(int[] preorder,int[] inorder,int start,int end){
        
        if(start > end ) return null;
        int rootValue = preorder[index++];
        TreeNode root = new TreeNode(rootValue);
        
        //find inorder index 
        int i=0;
        while(i <= end && inorder[i] != rootValue) i+=1;

        root.left = createTree(preorder,inorder,start,i-1);
        root.right = createTree(preorder,inorder,i+1,end);
        return root;

    }
}

/* 

in  = 3,9,6,10,20,15,7
pre = 6,9,10,3,15,20,7

*/