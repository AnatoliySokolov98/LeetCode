class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverseList(head);
        ListNode curr = head;
        int carry = 0;
        while (curr != null) {
            int total = (curr.val * 2 + carry) % 10;
            carry = (curr.val * 2 + carry) / 10;
            curr.val = total;
            curr = curr.next;
        }
        head = reverseList(head);
        if (carry != 0) {
            head = new ListNode(carry, head);
        }
        return head;
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}

// time O(n)
// space O(1)