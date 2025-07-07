
//date-6-jul-2025
//https://leetcode.com/problems/sort-list/description/

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
    ListNode merger_sorted_lists(ListNode head1,ListNode head2){
        ListNode dummy =new ListNode(0,null);
        ListNode cur=dummy;
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                cur.next=head1;
                head1=head1.next;
            }
            else{
                cur.next=head2;
                head2=head2.next;
            }
            cur=cur.next;
        }
        while(head1!=null){
            cur.next=head1;
            head1=head1.next;
            cur=cur.next;
        }
        while(head2!=null){
            cur.next=head2;
            head2=head2.next;
            cur=cur.next;
        }
        cur.next=null;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        ListNode head1=head;
        head2=sortList(head2);
        head1=sortList(head1);
        return merger_sorted_lists(head1,head2);
    }
}