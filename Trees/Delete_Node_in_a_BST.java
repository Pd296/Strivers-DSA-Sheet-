class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        return rtraverse(root,key);
    }

    public TreeNode rtraverse(TreeNode node, int key){
        if(node == null) return node;
        if(node.val == key){
            node = rdelete(node);
        }else if(node.val > key){
            node.left = rtraverse(node.left,key);
        }else{
            node.right = rtraverse(node.right, key);
        }
        return node;
    }
    public TreeNode rdelete(TreeNode node){
        if(node == null) return node;
        if(node.left == null && node.right == null){
            node = null;
        }else if(node.left != null && node.right == null){
            node = node.left;
        }else if(node.left == null && node.right != null){
            node = node.right;
        }else{
            int minikey = findMin(node.right);
            node.val = minikey;
            node.right = rtraverse(node.right,minikey);
        }
        return node;
    }

    public int findMin(TreeNode node){
        if(node.left == null){
            return node.val;
        }else{
            return findMin(node.left);
        }
    }
}
