
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (right > 0) {
            curr = curr.next;
            right--;
        }
        ListNode prev = curr.next;
        curr.next = null;
        ListNode curr2 = dummy;
        while (left > 1) {
            curr2 = curr2.next;
            left--;
        }
        head = curr2.next;
        curr2.next = curr;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return dummy.next;
    }
}