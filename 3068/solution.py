class Solution:
    def maximumValueSum(self, nums: list[int], k: int, edges: list[list[int]]) -> int:
        res = sum(nums)
        num_nodes = 0
        smallest_diff = float("inf")
        smallest_drop = float("inf")
        for num in nums:
            if num ^ k > num:
                diff = (num ^ k) - num
                res += diff
                smallest_diff = min(smallest_diff, diff)
                num_nodes += 1
            else:
                smallest_drop = min(smallest_drop, num - (num ^ k))
        if num_nodes % 2 == 0:
            return res
        return res - min(smallest_diff, smallest_drop)
        # time O(n)
        # space O(1)
