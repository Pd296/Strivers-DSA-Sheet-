class Solution {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return ans;
    }
    public int maxPath(TreeNode root){
        if(root==null) return 0;
        int l=Math.max(0,maxPath(root.left));
        int r=Math.max(0,maxPath(root.right));
        ans=Math.max(ans,(l+r+root.val));
        return root.val+Math.max(l,r);
    }
}