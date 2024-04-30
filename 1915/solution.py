class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        counts = [0] * (2**10)
        maps = {
            "a": 0,
            "b": 1,
            "c": 2,
            "d": 3,
            "e": 4,
            "f": 5,
            "g": 6,
            "h": 7,
            "i": 8,
            "j": 9,
        }
        mask = 0
        res = 0
        counts[0] = 1
        for char in word:
            mask ^= 1 << (maps[char])
            res += counts[mask]
            for i in range(10):
                new_mask = (1 << i) ^ mask
                res += counts[new_mask]
            counts[mask] += 1
        return res
