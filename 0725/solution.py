from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def splitListToParts(
        self, head: Optional[ListNode], k: int
    ) -> list[Optional[ListNode]]:
        curr = head
        elements = 0
        res = []
        while curr:
            elements += 1
            curr = curr.next

        nodes_per_part = elements // k
        extra_elements = elements % k

        curr = head
        prev = None
        while k:
            if not curr:
                res.append(None)
            else:
                for _ in range(nodes_per_part):
                    prev = curr
                    curr = curr.next
                if extra_elements:
                    prev = curr
                    curr = curr.next
                    extra_elements -= 1

                prev.next = None
                res.append(head)
                head = curr
            k -= 1
        return res
        # time O(n + k)
        # space O(1)
