class Solution:
    def threeConsecutiveOdds(self, arr: list[int]) -> bool:
        streak = 0
        for num in arr:
            if num % 2:
                streak += 1
                if streak == 3:
                    return True
            else:
                streak = 0
        return False
