class Solution:
    def removeElement(self, nums: list[int], val: int) -> int:
        write_to = 0
        for v in nums:
            if v != val:
                nums[write_to] = v
                write_to += 1
        return write_to
