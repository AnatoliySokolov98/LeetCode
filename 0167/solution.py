class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        left, right = 0, len(numbers) - 1
        while left < right:
            if numbers[left] + numbers[right] == target:
                return [left + 1, right + 1]
            if numbers[left] + numbers[right] < target:
                left += 1
            else:
                right -= 1
