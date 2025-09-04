//problem : https://www.geeksforgeeks.org/problems/largest-bst/1
class BST{
    boolean isBST;
    int min,max,ans,size;
    BST(boolean isBST,int min,int max,int ans,int size){
        this.isBST=isBST;
        this.min=min;
        this.max=max;
        this.ans=ans;
        this.size=size;
    }
}
class Solution {
    static int largestBst(Node root) {
        return findlargestBst(root).ans;
    }
    static BST findlargestBst(Node root){
        if(root==null) return new BST(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0,0);
        BST left=findlargestBst(root.left);
        BST right=findlargestBst(root.right);
        if(left.isBST && right.isBST && root.data>left.max && root.data<right.min){
            int size=left.size+right.size+1;
            int min=Math.min(root.data,left.min);
            int max=Math.max(root.data,right.max);
            return new BST(true,min,max,size,size);
        }
        return new BST(false,0,0,Math.max(left.ans,right.ans),0);
    }
}