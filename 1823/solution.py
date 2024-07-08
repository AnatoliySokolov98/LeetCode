from collections import deque


class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        nums = deque([i for i in range(1, n + 1)])
        while len(nums) > 1:
            for _ in range(k - 1):
                nums.append(nums.popleft())
            nums.popleft()
        return nums[0]
