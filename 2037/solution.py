class Solution:
    def minMovesToSeat(self, seats: list[int], students: list[int]) -> int:
        seats.sort()
        students.sort()
        return sum(abs(students[i] - seats[i]) for i in range(len(seats)))
