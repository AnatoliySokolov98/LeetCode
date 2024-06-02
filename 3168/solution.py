class Solution:
    def minimumChairs(self, s: str) -> int:
        res = 0
        curr = 0
        for char in s:
            if char == "E":
                curr += 1
            else:
                curr -= 1
            res = max(curr, res)
        return res
        # time O(n)
        # space O(1)
