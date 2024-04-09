class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        cache = {}
        for i, v in enumerate(nums):
            if target - v in cache:
                return [cache[target - v], i]
            cache[v] = i
