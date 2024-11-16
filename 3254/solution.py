class Solution:
    def resultsArray(self, nums: list[int], k: int) -> list[int]:
        curr = 0
        l = 0
        res = []
        for r in range(len(nums)):
            if r > 0 and nums[r] == nums[r - 1] + 1:
                curr += 1
            if r >= k:
                if nums[l + 1] == nums[l] + 1:
                    curr -= 1
                l += 1
            if r >= k - 1 and curr == k - 1:
                res.append(nums[r])
            elif r >= k - 1:
                res.append(-1)
        return res
