class Solution:
    def minOperations(self, s: str) -> int:
        total1 = 0
        total2 = 0
        curr1 = "0"
        curr2 = "1"
        for char in s:
            if char != curr1:
                total1 += 1
            else:
                total2 += 1
            curr1 = "1" if curr1 == "0" else "0"
            curr2 = "1" if curr2 == "0" else "0"
        return min(total1, total2)
        # time O(n)
        # space O(1)
