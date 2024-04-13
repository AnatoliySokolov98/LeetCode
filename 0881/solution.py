class Solution:
    def numRescueBoats(self, people: list[int], limit: int) -> int:
        people.sort()
        left, right = 0, len(people) - 1
        boats = 0
        while left <= right:
            if left == right:
                return boats + 1
            if people[right] + people[left] <= limit:
                left += 1
            boats += 1
            right -= 1
        return boats
