class Solution:
    def validPalindrome(self, s: str) -> bool:

        def pal(l, r):
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True

        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:
                if pal(left, right - 1) or pal(left + 1, right):
                    return True
                return False
            left += 1
            right -= 1
        return True

        # time O(n)
        # space O(1)
