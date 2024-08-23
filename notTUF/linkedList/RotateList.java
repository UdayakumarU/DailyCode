/*
61. Rotate List
Approach: Two pointer
Time complexity: O(n)
Space complexity: O(1)
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        ListNode leader = head;
        ListNode follower = head;
        int length = findLength(head);

        if(length <= 1) return head;
        k = k % length;

        while(k > 0){
            leader = leader.next;
            --k;
        }

        while(leader.next != null){
            leader = leader.next;
            follower = follower.next;
        }
        
        leader.next = head;
        head = follower.next;
        follower.next = null;

        return head;
    }

    private int findLength(ListNode head){
        int length = 0;
        while(head != null){
            head = head.next;
            ++length;
        }
        return length;
    }
    
}
