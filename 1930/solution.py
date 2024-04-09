class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        left = {}
        right = {}
        res = 0
        for i, char in enumerate(s):
            if char in left:
                right[char] = i
            else:
                left[char] = i

        for char in left:
            if char in right:
                chars = set()
                for i in range(left[char] + 1, right[char]):
                    chars.add(s[i])
                res += len(chars)
        return res
