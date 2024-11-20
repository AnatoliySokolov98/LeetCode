class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        # Initialize the count arrays
        left_counts = [0] * 3
        right_counts = [0] * 3
        r = len(s)

        # Check the right side condition
        while right_counts[0] < k or right_counts[1] < k or right_counts[2] < k:
            r -= 1
            if r < 0:
                return -1  # Not enough characters to satisfy the condition
            right_counts[ord(s[r]) - ord("a")] += 1

        # Initialize the result as the maximum possible value
        res = len(s) - r

        # Iterate through the left side of the string
        for l in range(len(s)):
            left_char = ord(s[l]) - ord("a")
            left_counts[left_char] += 1

            # Adjust the right side while maintaining the constraints
            while r < len(s):
                right_char = ord(s[r]) - ord("a")
                if right_counts[right_char] + left_counts[right_char] > k:
                    right_counts[right_char] -= 1
                    r += 1
                else:
                    break

            # Update the result with the minimum time required
            res = min(res, l + 1 + len(s) - r)

        return res
