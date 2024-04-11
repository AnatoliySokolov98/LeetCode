class Solution:
    def findDifference(self, nums1: list[int], nums2: list[int]) -> list[list[int]]:
        one = set(nums1)
        two = set(nums2)
        res = []
        res.append(list(one - two))
        res.append(list(two - one))
        return res
