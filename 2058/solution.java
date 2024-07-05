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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        int i = 1;
        int firstLoc = 0;
        int lastLoc = 0;
        ListNode curr = head.next;
        ListNode prev = head;

        while (curr.next != null) {
            if ((curr.val > curr.next.val && curr.val > prev.val)
                    || (curr.val < curr.next.val && curr.val < prev.val)) {
                if (firstLoc != 0) {
                    res[0] = Math.min(res[0], i - lastLoc);
                    res[1] = i - firstLoc;
                } else {
                    firstLoc = i;
                }
                lastLoc = i;
            }
            i++;
            curr = curr.next;
            prev = prev.next;
        }
        return res[0] == Integer.MAX_VALUE ? new int[] { -1, -1 } : res;
    }
}

// time O(n)
// space O(1)