/*
Date : 8th July 2025
Problem Link : https://leetcode.com/problems/sort-list/
 */
class Solution {
    public ListNode sortList(ListNode head) {
 
        if(head ==null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev= null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next = null;

        ListNode leftSide = sortList(head);
        ListNode rightSide = sortList(slow);

        return mergeList(leftSide , rightSide);
    }

    private ListNode mergeList(ListNode left,ListNode right){

        ListNode runner1 = left;
        ListNode runner2= right;

        ListNode newRunner = new ListNode(-1);
        ListNode newHead = newRunner;
        

        while(runner1 !=null && runner2 !=null){

            if(runner1.val < runner2.val) {
                newRunner.next = runner1;
                runner1 = runner1.next;
            }else{
                newRunner.next = runner2;
                runner2 = runner2.next;
            }

            newRunner = newRunner.next;

        }

        if(runner1 != null) {
            newRunner.next= runner1;
        }
        if(runner2 != null ) {
            newRunner.next = runner2;
        }
        return newHead.next;

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