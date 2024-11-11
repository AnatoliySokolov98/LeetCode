class Solution:
    def primeSubOperation(self, nums: list[int]) -> bool:
        biggest_num = max(nums)
        primes = [True] * (biggest_num + 1)
        primes[1] = False
        for i in range(2, len(primes)):
            if primes[i]:
                for j in range(i + i, len(primes), i):
                    primes[j] = False
        curr = 1
        for num in nums:
            while curr < num and primes[num - curr] == False:
                curr += 1
            if curr > num or primes[num - curr] == False:
                return False
            curr += 1
        return True
