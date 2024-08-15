class Solution:
    def firstUniqChar(self, s: str) -> int:
        counts = [0] * 26
        for char in s:
            counts[ord(char) - ord("a")] += 1
        for i in range(len(s)):
            if counts[ord(s[i]) - ord("a")] == 1:
                return i
        return -1
        # time O(n)
        # space O(1)
