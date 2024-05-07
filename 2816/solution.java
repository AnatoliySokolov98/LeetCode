class solution {
    int val;
    solution next;

    solution() {
    }

    solution(int val) {
        this.val = val;
    }

    solution(int val, solution next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public solution doubleIt(solution head) {
        head = reverseList(head);
        solution curr = head;
        int carry = 0;
        while (curr != null) {
            int total = (curr.val * 2 + carry) % 10;
            carry = (curr.val * 2 + carry) / 10;
            curr.val = total;
            curr = curr.next;
        }
        head = reverseList(head);
        if (carry != 0) {
            head = new solution(carry, head);
        }
        return head;
    }

    private solution reverseList(solution node) {
        solution prev = null;
        while (node != null) {
            solution next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}

// time O(n)
// space O(1)