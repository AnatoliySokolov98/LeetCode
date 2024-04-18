class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        write_to = 0
        last_number = float("inf")
        count_last = 1
        k = 0
        for i in range(len(nums)):
            if nums[i] != last_number:
                nums[write_to] = nums[i]
                last_number = nums[i]
                write_to += 1
                count_last = 1
                k += 1
            elif count_last < 2:
                nums[write_to] = nums[i]
                write_to += 1
                count_last += 1
                k += 1
        return k

        # time O(n)
        # space O(1)
