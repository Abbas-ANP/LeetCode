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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int size = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            size++;
        }
        if (size <= 2) return new int[] {-1, -1};

        ListNode prev = head;
        ListNode next = head.next.next;

        int i = 1, minDist = Integer.MAX_VALUE;
        int firstIdx = -1, lastIdx = -1, prevIdx = -1;

        for (ListNode curr = head.next; next != null; curr = curr.next) {
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                if (firstIdx == -1) {
                    firstIdx = i;
                } else {
                    minDist = Math.min(minDist, i - prevIdx);
                }

                prevIdx = i;
            }

            i++;
            prev = curr;
            next = next.next;
        }

        if (minDist == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }

        int maxDist = prevIdx - firstIdx;

        return new int[] {minDist, maxDist};
    }
}