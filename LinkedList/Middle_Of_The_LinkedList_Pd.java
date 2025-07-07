/*
Date : 5th July 2025
Problem link : https://leetcode.com/problems/middle-of-the-linked-list/
*/
class Solution {
    public ListNode middleNode(ListNode head) {
        
        if(head==null)return null;
        if(head.next==null)return head;
        
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}

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