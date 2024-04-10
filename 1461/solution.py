class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        codes = set()
        for i in range(len(s) - k + 1):
            codes.add(s[i : i + k])
        return len(codes) == 2**k
