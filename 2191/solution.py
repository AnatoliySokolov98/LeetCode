class Solution:
    def sortJumbled(self, mapping: list[int], nums: list[int]) -> list[int]:
        def new_num(num):
            if num == 0:
                return mapping[0]
            place = 1
            res = 0
            while num:
                digit = num % 10
                res += mapping[digit] * place
                num //= 10
                place *= 10
            return res

        return [
            x[1] for x in sorted(enumerate(nums), key=lambda x: (new_num(x[1]), x[0]))
        ]
