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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode prev = null;
        while (head != null) {
            if (prev != null) {
                curr.next = new ListNode(gcd(prev.val, head.val));
                curr = curr.next;
            }
            curr.next = head;
            prev = head;
            head = head.next;
            curr = curr.next;
            curr.next = null;
        }
        return dummy.next;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

// time O(n)
// space O(1)