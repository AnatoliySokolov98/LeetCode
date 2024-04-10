class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) > len(haystack):
            return -1
        N = len(needle)
        H = len(haystack)
        MOD = 10**9 + 7
        PRIME = 131
        powers = [1]
        for i in range(1, H):
            powers.append((powers[i - 1] * 31) % MOD)
        needle_hash = 0
        for i in range(N):
            needle_hash = (needle_hash + ord(needle[i]) * powers[i]) % MOD
        haystack_hash = {-1: 0}
        for i in range(H):
            haystack_hash[i] = (
                haystack_hash[i - 1] + ord(haystack[i]) * powers[i]
            ) % MOD
        for i in range(N - 1, H):
            curr_needle_hash = (needle_hash * powers[i - (N - 1)]) % MOD
            curr_haystack_hash = (haystack_hash[i] - haystack_hash[i - N]) % MOD
            if curr_needle_hash == curr_haystack_hash:
                return i - (N - 1)
        return -1
