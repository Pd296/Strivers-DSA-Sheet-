class Solution {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return max;
    }
    public int findDiameter(TreeNode root){
        if(root==null) return 0;
        int l=findDiameter(root.left);
        int r=findDiameter(root.right);
        max=Math.max(max,r+l);
        return 1+Math.max(r,l);
    }
}