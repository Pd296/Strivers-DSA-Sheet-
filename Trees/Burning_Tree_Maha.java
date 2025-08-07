class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> x =new HashMap<>();
        Queue<TreeNode> y=new LinkedList<>();
        y.add(root);
        TreeNode node =null;
        while(!y.isEmpty()) {
            TreeNode n = y.remove();
            if(n.val==start) node=n;
            if(n.left!=null) {
                x.put(n.left,n);
                y.add(n.left);
            }
            if(n.right!=null) {
                x.put(n.right,n);
                y.add(n.right);
            }
        }
        HashSet<TreeNode> z=new HashSet<>();
        y.add(node);
        z.add(node);
        int ans=-1;
        while(!y.isEmpty()){
            int size=y.size();
            ans++;
            for(int i=0;i<size;i++){
                TreeNode n=y.remove();
                if(n.left!=null && !z.contains(n.left)){
                    y.add(n.left);
                    z.add(n.left);
                }
                if(n.right!=null && !z.contains(n.right)){
                    y.add(n.right);
                    z.add(n.right);
                }
                TreeNode parent=x.get(n);
                if(parent!=null && !z.contains(parent)) {
                    y.add(parent);
                    z.add(parent);
                }
            }
        }
        return ans;
    }
}