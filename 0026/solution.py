class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        last_num = float("-inf")
        k = 0
        for i in range(len(nums)):
            if nums[i] != last_num:
                nums[k] = nums[i]
                last_num = nums[i]
                k += 1
        return k

        # time O(n)
        # space O(1)
