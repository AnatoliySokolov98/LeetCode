class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int half = (length / 2) - 1;
        curr = head;
        for (int i = 0; i < half; i++) {
            curr = curr.next;
        }

        ListNode secondList = curr.next;
        curr.next = null;

        ListNode prev = null;
        while (secondList != null) {
            ListNode next = secondList.next;
            secondList.next = prev;
            prev = secondList;
            secondList = next;
        }

        while (prev != null && head != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
// time O(n)
// space O(1)