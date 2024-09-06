import java.util.HashSet;
import java.util.Set;

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> badValues = new HashSet<>();
        for (int num : nums) {
            badValues.add(num);
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (head != null) {
            if (!badValues.contains(head.val)) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
            curr.next = null;
        }
        return dummy.next;
    }
}

// time O(n)
// space O(1)