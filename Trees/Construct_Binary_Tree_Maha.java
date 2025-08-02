class Solution {
    int in=0;
    HashMap<Integer,Integer> x;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        x=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            x.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder,int s,int e) {
        if(s>e) return null;
        int rootVal=preorder[in++];
        TreeNode root=new TreeNode(rootVal);
        int index=x.get(rootVal);
        root.left=build(preorder,s,index-1);
        root.right=build(preorder,index+1,e);
        return root;
    }
}