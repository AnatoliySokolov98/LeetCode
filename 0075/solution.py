class Solution:
    def sortColors(self, nums: list[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        reds, whites, blues = 0, 0, 0
        for num in nums:
            if num == 0:
                reds += 1
            if num == 1:
                whites += 1
            if num == 2:
                blues += 1

        index = 0
        while reds > 0:
            nums[index] = 0
            index += 1
            reds -= 1
        while whites > 0:
            nums[index] = 1
            index += 1
            whites -= 1
        while blues > 0:
            nums[index] = 2
            index += 1
            blues -= 1
