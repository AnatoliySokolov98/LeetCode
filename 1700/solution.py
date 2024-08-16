class Solution:
    def countStudents(self, students: list[int], sandwiches: list[int]) -> int:
        ones = 0
        zeroes = 0
        for student in students:
            if student == 0:
                zeroes += 1
            else:
                ones += 1
        for i, sandwich in enumerate(sandwiches):
            if sandwich == 0 and zeroes:
                zeroes -= 1
            elif sandwich == 1 and ones:
                ones -= 1
            else:
                return len(sandwiches) - i
        return 0
