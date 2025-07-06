
//date-6-jul-2025
//problem_link-https://leetcode.com/problems/odd-even-linked-list/description/

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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode even=new ListNode(0,null);
        ListNode even_head=even;
        ListNode cur=head;
        while(cur!=null && cur.next!=null){
            even.next=cur.next;
            cur.next=cur.next.next;
            even.next.next=null;
            even=even.next;
            cur=cur.next==null ? cur : cur.next;
        }
        cur.next=even_head.next;
        return head;
    }
}