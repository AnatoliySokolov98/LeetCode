class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        s = s.split()
        if len(s) != len(pattern):
            return False
        left, right = {}, {}
        for i in range(len(s)):
            if pattern[i] not in left:
                left[pattern[i]] = s[i]
            else:
                if left[pattern[i]] != s[i]:
                    return False
            if s[i] not in right:
                right[s[i]] = pattern[i]
            else:
                if right[s[i]] != pattern[i]:
                    return False
        return True
