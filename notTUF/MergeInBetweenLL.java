/**
 1669. Merge In Between Linked Lists
 Link: https://leetcode.com/problems/merge-in-between-linked-lists/
 Time complexity: O(n)
 Space complexity: O(1)
 
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        // find a-1 node
        ListNode aNode = list1;
        int start = 1;
        while(start < a){
            aNode = aNode.next;
            ++start;
        }
        
        // find b node
        ListNode bNode = aNode.next;
        while(start < b){
            bNode = bNode.next;
            ++start;
        }

        //connect the start; find list2 last node; connect the last
        aNode.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }
        list2.next = bNode.next;

        return list1;
    }
}
