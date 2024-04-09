class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        left = {}
        right = {}
        if len(s) != len(t):
            return False

        for i in range(len(s)):
            if s[i] in left:
                if left[s[i]] != t[i]:
                    return False
            else:
                left[s[i]] = t[i]

            if t[i] in right:
                if right[t[i]] != s[i]:
                    return False
            else:
                right[t[i]] = s[i]

        return True
