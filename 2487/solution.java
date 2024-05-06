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
    public ListNode removeNodes(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr = prev;
        int biggest = curr.val;
        while (curr.next != null) {
            if (curr.next.val >= biggest) {
                curr = curr.next;
                biggest = Math.max(biggest, curr.val);
            } else {
                curr.next = curr.next.next;
            }
        }
        curr = prev;
        prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

// time O(n)
// space O(1)