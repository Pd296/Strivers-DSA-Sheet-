// Problem link : https://leetcode.com/problems/sort-list/description/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:

    ListNode* merge(ListNode* l1, ListNode* l2) {
        ListNode *list = new ListNode(-1);
        ListNode *curr = list;
        while(l1 != NULL && l2 != NULL) {
            if(l1->val <= l2->val) {
                curr->next = l1;
                l1 = l1->next;
            }
            else{
                curr->next = l2;
                l2 = l2->next;
            }
            curr=curr->next;
        }
        if(l1 != NULL) {
            curr->next = l1;
            l1 = l1->next;
        }
        if(l2 != NULL) {
            curr->next = l2;
            l2 = l2->next;
        }
        return list->next;

    }
    ListNode* sortList(ListNode* head) {
        if(head == NULL || head->next == NULL) { return head; }   
    
    ListNode *slow = head;
    ListNode *fast = head;
    ListNode *temp = head;
    while(fast != NULL && fast->next != NULL) {
        temp = slow;
        slow = slow->next;
        fast = fast->next->next;
    }
    temp->next = NULL;

    //now we divided ll to two seperate halfs

    ListNode *l1 = sortList(head);
    ListNode *l2 = sortList(slow);
    return merge(l1, l2);
    }
    

};
