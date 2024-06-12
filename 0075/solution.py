class Solution:
    def sortColors(self, nums: list[int]) -> None:
        l = 0
        r = len(nums) - 1
        i = 0
        while i <= r:
            if i < l:
                i += 1
                continue
            curr = nums[i]
            if curr == 0:
                nums[i] = nums[l]
                nums[l] = 0
                l += 1
            elif curr == 2:
                nums[i] = nums[r]
                nums[r] = 2
                r -= 1
            else:
                i += 1
