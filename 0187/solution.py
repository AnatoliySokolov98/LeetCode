class Solution:
    def findRepeatedDnaSequences(self, s: str) -> list[str]:
        left, right = 0, 9
        seen, res = set(), set()
        while right < len(s):
            temp = s[left : right + 1]
            if temp in seen:
                res.add(temp)
            else:
                seen.add(temp)
            right += 1
            left += 1
        return res

    # time O(n)
    # space O(n)
