from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def rev(node):
            curr, prev = node, None
            while curr:
                nxt = curr.next
                curr.next = prev
                prev, curr = curr, nxt
            return prev

        head = rev(head)
        cin = 0
        curr = head
        while curr:
            total = (curr.val * 2 + cin) % 10
            cin = (curr.val * 2 + cin) // 10
            curr.val = total
            curr = curr.next
        head = rev(head)
        if cin:
            head = ListNode(cin, head)
        return head
