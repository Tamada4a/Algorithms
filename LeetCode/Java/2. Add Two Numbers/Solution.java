/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;

        // Pointer to the beginning of the list
        ListNode resultNode = null;

        // A pointer to the current list item
        ListNode subNode = null;

        // Iterate until both lists run out
        while (l1 != null || l2 != null) {
            // Add an element of the first list to the remainder of the previous amount and move
            // the pointer
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // To the remainder of the previous amount, add the second of the first list and move
            // the pointer
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // If there is no pointer to the beginning of the list, initialize it and the pointer
            // to the current element
            if (resultNode == null) {
                resultNode = new ListNode(sum % 10);
                subNode = resultNode;
            }
            // Otherwise, we change the value of the next element and move the pointer
            else {
                subNode.next = new ListNode(sum % 10);
                subNode = subNode.next;
            }

            // The remainder of the division will be stored here, which will move to the next iteration
            sum /= 10;
        }

        // If there is a remainder left after exiting the loop, add it to the list
        if (sum != 0)
            subNode.next = new ListNode(sum);

        return resultNode;
    }
}