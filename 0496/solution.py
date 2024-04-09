class Solution:
    def nextGreaterElement(self, nums1: list[int], nums2: list[int]) -> list[int]:
        locations = {}

        next_greater = [-1] * len(nums2)
        stack = []

        for i in range(len(nums2)):
            locations[nums2[i]] = i
            while stack and nums2[i] > stack[-1][1]:
                index, _ = stack.pop()
                next_greater[index] = nums2[i]
            stack.append([i, nums2[i]])
        res = []
        for num in nums1:
            res.append(next_greater[locations[num]])
        return res
