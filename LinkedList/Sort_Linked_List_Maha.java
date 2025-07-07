/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode node=split(head);
        head=sortList(head);
        node=sortList(node);
        return merge(head,node);
    }
    public static ListNode split(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        return temp;
    }
    public static ListNode merge(ListNode node1,ListNode node2){
        if(node1==null) return node2;
        if(node2==null) return node1;
        if(node1.val<node2.val){
            node1.next=merge(node1.next,node2);
            return node1;
        }
        else{
            node2.next=merge(node1,node2.next);
            return node2;
        }
    }
}