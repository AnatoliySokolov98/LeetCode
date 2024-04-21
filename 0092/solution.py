from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseBetween(
        self, head: Optional[ListNode], left: int, right: int
    ) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        curr, prev = dummy, None
        index = 0
        while index < left:
            prev = curr
            curr = curr.next
            index += 1

        left = prev
        left.next = None
        head = curr

        while index < right + 1:
            prev = curr
            curr = curr.next
            index += 1

        prev.next = None
        prev = curr

        while head:
            temp = head.next
            head.next = prev
            prev = head
            head = temp
        left.next = prev
        return dummy.next
        # time O(n)
        # space O(1)
