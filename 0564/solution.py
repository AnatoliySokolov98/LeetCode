class Solution:
    def nearestPalindromic(self, n: str) -> str:
        N = len(n)

        # Handle the edge case for single-digit numbers
        if N == 1:
            return str(int(n) - 1)

        original = int(n)
        less_digits = 10 ** (N - 1) - 1
        more_digits = 10 ** (N) + 1

        # Build possible palindrome candidates
        half_val = int(n[: (N + 1) // 2])

        def build_pal(num):
            num_str = str(num)
            if len(num_str) < N // 2 + 1:
                return int(num_str + num_str[::-1])
            return int(num_str + num_str[-2::-1])

        same = build_pal(half_val)
        smaller = build_pal(half_val - 1)
        bigger = build_pal(half_val + 1)

        # Collect all candidates
        candidates = {less_digits, more_digits, smaller, same, bigger}

        # Remove the original number itself from candidates if present
        candidates.discard(original)

        # Find the closest palindrome
        closest = min(candidates, key=lambda x: (abs(x - original), x))
        return str(closest)
