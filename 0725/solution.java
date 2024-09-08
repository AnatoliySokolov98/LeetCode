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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int piece = len / k;
        int extra = len % k;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        curr = head;
        for (int i = 0; i < k; i++) {
            int j = piece + (i < extra ? 1 : 0);
            ListNode beforeStart = prev;
            while (j > 0) {
                prev = curr;
                curr = curr.next;
                j--;
            }
            res[i] = beforeStart.next;
            beforeStart.next = null;
        }
        return res;
    }
}

// time O(n)
// space O(1)