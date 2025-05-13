class Solution:
    def maxTotalFruits(self, fruits: list[list[int]], startPos: int, k: int) -> int:
        n = len(fruits)
        left = 0
        total = 0
        max_fruits = 0

        for right in range(n):
            total += fruits[right][1]

            while left <= right:
                left_pos = fruits[left][0]
                right_pos = fruits[right][0]

                # Calculate minimum steps to visit all fruits from left to right
                dist = min(
                    abs(startPos - left_pos) + (right_pos - left_pos),  # go left first
                    abs(startPos - right_pos) + (right_pos - left_pos)  # go right first
                )

                if dist <= k:
                    break
                total -= fruits[left][1]
                left += 1

            max_fruits = max(max_fruits, total)

        return max_fruits
