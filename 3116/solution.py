class Solution:
    def findKthSmallest(self, coins: list[int], k: int) -> int:
        lcms = []
        i = 0
        coins.sort()
        while i < len(coins):
            j = i + 1
            while j < len(coins):
                if coins[j] % coins[i] == 0:
                    coins = coins[:j] + coins[j + 1 :]
                else:
                    j += 1
            i += 1
        duplicates = []
        for i in range(1, 2 ** (len(coins))):
            lcms = []
            for j in range(len(coins)):
                if (1 << j) & i:
                    lcms.append(coins[j])
            res = lcm(*lcms)
            if len(lcms) % 2 == 0:
                res *= -1
            duplicates.append(res)

        def num_amounts(num):
            res = 0
            for duplicate in duplicates:
                if duplicate < 0:
                    res -= num // (-duplicate)
                else:
                    res += num // duplicate
            return res

        l, r = 1, min(coins) * k
        res = -1
        while l <= r:
            p = (l + r) // 2
            output = num_amounts(p)
            if output >= k:
                r = p - 1
                res = p
            else:
                l = p + 1
        return res
        # time O(2**(coins) + log(k * min(coins)) * coins)
        # space O(2**(coins))
