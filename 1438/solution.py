from collections import deque


class Solution:
    def longestSubarray(self, nums: list[int], limit: int) -> int:
        dec = deque()
        inc = deque()
        l = 0
        res = 0
        for r in range(len(nums)):
            while dec and nums[r] > dec[-1][1]:
                dec.pop()
            while inc and nums[r] < inc[-1][1]:
                inc.pop()
            dec.append([r, nums[r]])
            inc.append([r, nums[r]])
            while dec[0][1] - inc[0][1] > limit:
                l += 1
                if dec[0][0] < l:
                    dec.popleft()
                if inc[0][0] < l:
                    inc.popleft()
            res = max(res, r - l + 1)
        return res
