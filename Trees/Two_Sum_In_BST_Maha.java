class Solution {
    HashSet<Integer> x=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return checkNumbers(root,k);
    }
    public boolean checkNumbers(TreeNode n,int k){
        if(n==null) return false;
        if(x.contains(k-n.val)) return true;
        x.add(n.val);
        return checkNumbers(n.left,k) || checkNumbers(n.right,k);
    }
}