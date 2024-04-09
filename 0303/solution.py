class NumArray:

    def __init__(self, nums: list[int]):
        self.sums = [nums[0]]
        for i in range(1, len(nums)):
            self.sums.append(self.sums[-1] + nums[i])

    def sumRange(self, left: int, right: int) -> int:
        if left == 0:
            return self.sums[right]
        return self.sums[right] - self.sums[left - 1]
