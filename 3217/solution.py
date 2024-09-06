from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def modifiedList(
        self, nums: list[int], head: Optional[ListNode]
    ) -> Optional[ListNode]:
        nums = set(nums)
        dummy = ListNode()
        curr = dummy
        while head:
            if head.val not in nums:
                curr.next = head
                head = head.next
                curr = curr.next
                curr.next = None
            else:
                head = head.next
        return dummy.next

        # time O(n + l)
        # space O(n)
