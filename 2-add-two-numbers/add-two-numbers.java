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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (size(l1) < size(l2)) return addTwoNumbers(l2, l1);
        ListNode res = l1;
        int sum = 0, carry = 0, val = 0;

        while (l1 != null) {
            int val2 = (l2 == null) ? 0 : l2.val;
            
            sum = l1.val + val2 + carry;
            val = sum % 10;
            carry = sum / 10;

            l1.val = val;

            if (l1.next == null && carry != 0) {
                l1.next = new ListNode(carry);
                break;
            }

            l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return res;
    }

    private static int size(ListNode l) {
        int s = 0;
        for (; l != null; l = l.next) s++;
        return s;
    }
}