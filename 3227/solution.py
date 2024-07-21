class Solution:
    def doesAliceWin(self, s: str) -> bool:
        vowels = {"a", "e", "i", "o", "u"}
        for char in s:
            if char in vowels:
                return True
        return False
        # time O(n)
        # space O(1)
