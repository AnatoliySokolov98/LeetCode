from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def insertGreatestCommonDivisors(
        self, head: Optional[ListNode]
    ) -> Optional[ListNode]:
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a

        dummy = ListNode()
        curr = dummy
        prev = None
        while head:
            if prev:
                curr.next = ListNode(gcd(prev.val, head.val))
                curr = curr.next
            prev = head
            curr.next = head
            head = head.next
            curr = curr.next
            curr.next = None
        return dummy.next
