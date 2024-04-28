class Solution:
    def minimumAddedInteger(self, nums1: list[int], nums2: list[int]) -> int:
        nums1.sort()
        nums2.sort()
        res = float("inf")

        def check(diff):
            i = 0
            errors = 0
            for num in nums2:
                while nums1[i] + diff != num:
                    errors += 1
                    if errors > 2:
                        return False
                    i += 1
                i += 1
            return True

        for i in range(3):
            diff = nums2[0] - nums1[i]
            if check(diff):
                res = min(res, diff)
        return res

        # time O(nlog(n))
        # space O(1)
