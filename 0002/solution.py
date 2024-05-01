from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(
        self, l1: Optional[ListNode], l2: Optional[ListNode]
    ) -> Optional[ListNode]:
        dummy = ListNode()
        curr = dummy
        cin = 0
        while l1 or l2 or cin:
            first = l1.val if l1 else 0
            second = l2.val if l2 else 0
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
            res = (first + second + cin) % 10
            cin = (first + second + cin) // 10
            curr.next = ListNode(res)
            curr = curr.next
        return dummy.next
