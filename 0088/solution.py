class Solution:
    def merge(self, nums1: list[int], m: int, nums2: list[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        write_to = len(nums1) - 1
        m -= 1
        n -= 1
        while m >= 0 and n >= 0:
            if nums1[m] > nums2[n]:
                nums1[write_to] = nums1[m]
                m -= 1
            else:
                nums1[write_to] = nums2[n]
                n -= 1
            write_to -= 1

        while m >= 0:
            nums1[write_to] = nums1[m]
            m -= 1
            write_to -= 1

        while n >= 0:
            nums1[write_to] = nums2[n]
            n -= 1
            write_to -= 1

        # time O(n)
        # space O(1)
