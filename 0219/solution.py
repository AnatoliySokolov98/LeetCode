class Solution:
    def containsNearbyDuplicate(self, nums: list[int], k: int) -> bool:
        locations = {}
        for i in range(len(nums)):
            if nums[i] not in locations:
                locations[nums[i]] = i
            else:
                if abs(locations[nums[i]] - i) <= k:
                    return True
                locations[nums[i]] = i
        return False

        # time O(n)
        # space O(n)
