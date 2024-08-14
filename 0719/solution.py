class Solution:
    def smallestDistancePair(self, nums: list[int], k: int) -> int:
        nums.sort()

        def countPairs(dist: int) -> int:
            count = left = 0
            for right in range(len(nums)):
                while nums[right] - nums[left] > dist:
                    left += 1
                count += right - left
            return count

        left, right = 0, nums[-1] - nums[0]
        while left < right:
            mid = (left + right) // 2
            if countPairs(mid) >= k:
                right = mid
            else:
                left = mid + 1

        return left
