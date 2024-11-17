from collections import deque


class Solution:
    def shortestSubarray(self, nums: list[int], k: int) -> int:
        stack = deque()
        stack.append([-1, 0])
        res = float("inf")
        total = 0
        for i, v in enumerate(nums):
            if v >= k:
                return 1
            total += v
            while stack and total <= stack[-1][-1]:
                stack.pop()
            stack.append([i, total])
            while len(stack) >= 2 and stack[-1][-1] - stack[0][-1] >= k:
                res = min(res, stack[-1][0] - stack[0][0])
                stack.popleft()
        return res if res != float("inf") else -1
