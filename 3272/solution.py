from math import factorial


class Solution:
    def countGoodIntegers(self, n: int, k: int) -> int:
        counts = [0] * 10
        nums = [0] * n
        visited = set()
        res = 0

        def count_permutations(freq):
            total_perm = factorial(n)
            for c in freq:
                total_perm //= factorial(c)
            c0 = freq[0]
            if c0 > 0:
                lead_zero = factorial(n - 1) // factorial(c0 - 1)
                for d in range(1, 10):
                    lead_zero //= factorial(freq[d])
                return total_perm - lead_zero
            else:
                return total_perm

        def check_and_count():
            nonlocal res
            num = 0
            for d in nums:
                num = num * 10 + d
            if num % k != 0:
                return
            key = tuple(counts)
            if key in visited:
                return
            visited.add(key)
            res += count_permutations(counts)

        def backtrack(i):
            if i > (n - 1) // 2:
                check_and_count()
                return
            
            if (n % 2 == 1) and (i == n // 2):
                for digit in range(10):
                    
                    counts[digit] += 1
                    nums[i] = digit
                    backtrack(i + 1)
                    nums[i] = 0
                    counts[digit] -= 1
                return

            start = 0
            if i == 0 and n > 1:
                start = 1

            for digit in range(start, 10):
                counts[digit] += 2
                nums[i] = digit
                nums[n - 1 - i] = digit
                backtrack(i + 1)
                counts[digit] -= 2
                nums[i] = 0
                nums[n - 1 - i] = 0

        backtrack(0)
        return res
