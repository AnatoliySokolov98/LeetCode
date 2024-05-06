from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, curr = None, head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        biggest = float("-inf")
        dummy = ListNode(float("-inf"), prev)
        curr = dummy
        while curr.next:
            if curr.next.val < biggest:
                curr.next = curr.next.next
            else:
                curr = curr.next
                biggest = max(biggest, curr.val)
        curr, prev = dummy.next, None
        dummy.next = None
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev
