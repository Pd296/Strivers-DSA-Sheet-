// Problem st- https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

import java.util.Hashtable;

class Solution {
  public Hashtable<Integer, Integer> ht;
   public Solution(){
    ht = new Hashtable<>();
   }
    public boolean findTarget(TreeNode root, int k) {
        if(k>=0 && k<minimum(root)) return false;
        if(k>=0 && k>=2*maximum(root)) return false;
        if(k<0) return bfs(root,k);
        else return dfs(root,k);
    }

    public int minimum(TreeNode node){
        if(node.left == null) return node.val;
        int min = minimum(node.left);
        return min;
    }

    public int maximum(TreeNode node){
        if(node.right == null) return node.val;
        int max= maximum(node.right);
        return max;
    }



    public boolean bfs(TreeNode node, int k){
        TreeNode currentNode = node;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            // results.add(currentNode.val);
            ht.put(currentNode.val,k-currentNode.val);
            if(k-currentNode.val != currentNode.val && ht.get(k-currentNode.val) != null){
                return true;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return false;
    }

    public boolean dfs(TreeNode node, int k){
        if(node!= null) {
            ht.put(node.val,k-node.val);
        }else return false;
        if(k-node.val == node.val)return bfs(node,k);
        if(k-node.val != node.val && ht.get(k-node.val) != null)return true;
        boolean left = dfs(node.left,k);
        boolean right =  dfs(node.right,k);
        if(left || right) return true;
        return false;
    }

}
