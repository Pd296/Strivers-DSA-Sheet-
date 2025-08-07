class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pp=new ArrayList<>();
        ArrayList<TreeNode> pq=new ArrayList<>();
        findPath(root,p,pp);
        findPath(root,q,pq);
        TreeNode ans=root;
        for(int i=0;i<pp.size();i++){
            if(i==pq.size() || pp.get(i)!=pq.get(i)) return ans;
            ans=pp.get(i);
        }
        return ans;
        // return LCA(root,p,q);
    }
    public boolean findPath(TreeNode root,TreeNode node,ArrayList<TreeNode> al){
        if(root==null) return false;
        al.add(root);
        if(root==node) return true;
        if(findPath(root.left,node,al) || findPath(root.right,node,al)) return true;
        al.remove(al.size()-1);
        return false;
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode l=LCA(root.left, p, q);
        TreeNode r=LCA(root.right, p, q);
        if(l!=null && r!=null) return root;
        return l!=null?l:r;
    }
}