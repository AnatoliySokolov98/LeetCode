from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        curr = dummy
        total = 0
        head = head.next
        while head:
            while head.val != 0:
                total += head.val
                head = head.next
            curr = curr.next
            curr.val = total
            total = 0
            head = head.next
        curr.next = None
        return dummy.next
