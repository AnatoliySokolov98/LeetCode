from collections import Counter


class Solution:
    def numberOfPairs(self, nums1: list[int], nums2: list[int], k: int) -> int:
        n1 = []
        for num in nums1:
            if num % k == 0:
                n1.append(num // k)
        if len(n1) == 0:
            return 0
        nums2_counts = Counter(num for num in nums2)
        biggest = max(n1) + 1
        multiples = [0] * biggest

        for num, count in nums2_counts.items():
            for i in range(num, biggest, num):
                multiples[i] += count

        res = 0
        for num in n1:
            res += multiples[num]
        return res

    # time O(nums1 + nums2log(nums2))
    # space O(nums1 + nums2)
