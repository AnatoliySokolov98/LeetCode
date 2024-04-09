class Solution:
    def minSwaps(self, s: str) -> int:
        res = 0
        count = 0
        for char in s:
            if char == "[":
                count += 1
            if char == "]":
                count -= 1
                if count < 0:
                    res += 1
                    count += 2
        return res
