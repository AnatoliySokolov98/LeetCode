class Solution:
    def moveZeroes(self, nums: list[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        write_to = 0
        k = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[write_to] = nums[i]
                write_to += 1
            else:
                k += 1
        index = -1

        while k > 0:
            nums[index] = 0
            index -= 1
            k -= 1

        # time O(n)
        # space O(1)
