from collections import defaultdict
from functools import cache


class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        R = len(ring)
        locs = defaultdict(list)
        for i in range(R):
            locs[ring[i]].append(i)

        # how many turns we need
        def find_moves(char, idx):
            positions = locs[char]
            if idx > positions[-1]:
                return idx - positions[-1], R - idx + positions[0]
            if idx < positions[0]:
                return idx + R - positions[-1], positions[0] - idx
            right = float("inf")
            l, r = 0, len(positions) - 1
            while l <= r:
                p = (l + r) // 2
                if positions[p] > idx:
                    right = p
                    r = p - 1
                else:
                    l = p + 1
            return idx - positions[right - 1], positions[right] - idx

        @cache
        def dp(curr, key_pos):
            if key_pos == len(key):
                return 0
            if ring[curr] == key[key_pos]:
                return 1 + dp(curr, key_pos + 1)
            left_turns, right_turns = find_moves(key[key_pos], curr)
            left_loc = (curr - left_turns) % R
            right_loc = (curr + right_turns) % R
            return min(
                left_turns + 1 + dp(left_loc, key_pos + 1),
                right_turns + 1 + dp(right_loc, key_pos + 1),
            )

        return dp(0, 0)
