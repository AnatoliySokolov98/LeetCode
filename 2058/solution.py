from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> list[int]:
        prev, curr = head, head.next
        first_loc, last_loc = None, None
        res = [float("inf"), float("-inf")]
        index = 1

        while curr.next:
            if (curr.val > prev.val and curr.val > curr.next.val) or (
                curr.val < prev.val and curr.val < curr.next.val
            ):
                if first_loc is None:
                    first_loc = index
                else:
                    res[0] = min(res[0], index - last_loc)
                    res[1] = index - first_loc
                last_loc = index
            prev, curr = curr, curr.next
            index += 1

        return res if res[0] != float("inf") else [-1, -1]
