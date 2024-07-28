class Solution:
    def canAliceWin(self, nums: list[int]) -> bool:
        total = 0
        for num in nums:
            if num < 10:
                total += num
            else:
                total -= num
        return total != 0

        # time O(n)
        # space O(1)
