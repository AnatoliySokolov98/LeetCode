class Solution:
    def beautifulSubsets(self, nums: list[int], k: int) -> int:
        res = 0
        subset = []

        def backtrack(i):
            if i == len(nums):
                nonlocal res
                res += len(subset) != 0
                return
            check = True
            for num in subset:
                if abs(num - nums[i]) == k:
                    check = False
                    break
            if check:
                subset.append(nums[i])
                backtrack(i + 1)
                subset.pop()
            backtrack(i + 1)

        backtrack(0)
        return res
