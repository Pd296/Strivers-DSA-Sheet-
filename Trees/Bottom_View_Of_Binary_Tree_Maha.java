/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer,Integer> y=new TreeMap<>();
        Queue<Node> q=new LinkedList<>();
        root.hd=0;
        q.add(root);
        while(q.size()>0){
            Node n=q.remove();
            int h=n.hd;
            y.put(h,n.data);
            if(n.left!=null){
                q.add(n.left);
                n.left.hd=h-1;
            }
            if(n.right!=null){
                q.add(n.right);
                n.right.hd=h+1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(y.values());
        return ans;
    }
}