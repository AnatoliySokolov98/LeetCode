class Solution:
    def nthUglyNumber(self, n: int) -> int:
        two, three, five = 0, 0, 0
        nums = [0] * n
        nums[0] = 1

        for i in range(1, n):
            next_two = nums[two] * 2
            next_three = nums[three] * 3
            next_five = nums[five] * 5

            nums[i] = min(next_two, next_three, next_five)

            if nums[i] == next_two:
                two += 1
            if nums[i] == next_three:
                three += 1
            if nums[i] == next_five:
                five += 1

        return nums[-1]
