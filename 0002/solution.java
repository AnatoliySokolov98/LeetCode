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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cin = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            int total = cin;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            cin = total / 10;
            total %= 10;
            curr.next = new ListNode(total);
            curr = curr.next;
        }
        if (cin == 1) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }
}