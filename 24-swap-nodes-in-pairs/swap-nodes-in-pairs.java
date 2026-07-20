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

    public ListNode swapPairs(ListNode head) {

        // If list has 0 or 1 node, no swap needed
        if (head == null || head.next == null)
            return head;

        // Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev points to node before current pair
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = first.next;

            // Step 1
            prev.next = second;

            // Step 2
            first.next = second.next;

            // Step 3
            second.next = first;

            // Move to next pair
            prev = first;
        }

        return dummy.next;
    }
}