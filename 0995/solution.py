from collections import deque


class Solution:
    def minKBitFlips(self, nums: list[int], k: int) -> int:
        flips = deque()
        res = 0
        for i in range(len(nums)):
            if flips and flips[0] < i:
                flips.popleft()
            curr = (nums[i] + len(flips)) % 2
            if curr == 0:
                if i > len(nums) - k:
                    return -1
                flips.append(i + k - 1)
                res += 1
        return res
