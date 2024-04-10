class Solution:
    def checkSubarraySum(self, nums: list[int], k: int) -> bool:
        mods = {0: -1}
        total = 0
        for i, v in enumerate(nums):
            total += v
            mod = total % k
            if mod in mods:
                if i - mods[mod] >= 2:
                    return True
            else:
                mods[mod] = i
        return False

    # time O(n)
    # space O(n)
