class Solution:
    def sortArray(self, nums: list[int]) -> list[int]:
        def split(nums):
            if len(nums) <= 1:
                return nums
            mid = len(nums) // 2
            return merge(split(nums[:mid]), split(nums[mid:]))

        def merge(a, b):
            res = []
            i, j = 0, 0
            while i < len(a) or j < len(b):
                if i == len(a):
                    res.append(b[j])
                    j += 1
                elif j == len(b):
                    res.append(a[i])
                    i += 1
                elif a[i] <= b[j]:
                    res.append(a[i])
                    i += 1
                else:
                    res.append(b[j])
                    j += 1
            return res

        return split(nums)
