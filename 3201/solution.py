class Solution:
    def maximumLength(self, nums: list[int]) -> int:
        odds, evens = 0, 0
        odd_start = 0
        even_start = 0
        curr_odd = True
        curr_even = True
        for num in nums:
            if num % 2 == 0:
                evens += 1
                if curr_even:
                    even_start += 1
                    curr_even = False
                if not curr_odd:
                    odd_start += 1
                    curr_odd = True
            else:
                odds += 1
                if curr_odd:
                    odd_start += 1
                    curr_odd = False
                if not curr_even:
                    even_start += 1
                    curr_even = True
        return max(evens, odds, odd_start, even_start)
        # time O(n)
        # space O(1)
