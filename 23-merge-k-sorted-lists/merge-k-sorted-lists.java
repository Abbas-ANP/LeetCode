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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < lists.length; i++) {
            for (ListNode temp = lists[i]; temp != null; temp = temp.next) {
                pq.offer(temp.val);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode node = new ListNode(pq.poll());
            temp.next = node;
            temp = temp.next;
        }

        temp.next = null;

        return dummy.next;
    }
}