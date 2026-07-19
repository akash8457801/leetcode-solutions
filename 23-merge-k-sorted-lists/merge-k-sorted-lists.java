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

    public ListNode mergeKLists(ListNode[] lists) {

        // Min Heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Put first node of every list
        for (ListNode node : lists) {

            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            // Smallest node
            ListNode node = pq.poll();

            current.next = node;
            current = current.next;

            // Insert next node from same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}