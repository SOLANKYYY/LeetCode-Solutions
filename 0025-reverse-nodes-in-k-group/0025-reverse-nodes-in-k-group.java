class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;

        // Check if there are k nodes available
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }

        // Reverse first k nodes
        ListNode prev = null;
        ListNode current = head;

        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // head is now the last node of reversed group
        head.next = reverseKGroup(current, k);

        return prev;
    }
}