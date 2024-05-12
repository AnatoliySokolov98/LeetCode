class Solution:
    def findProductsOfElements(self, queries: list[list[int]]) -> list[int]:
        def count_ones(num):
            res = 0
            start = 1
            while start <= num:
                res += (num + 1) // (start * 2) * (start)
                extra = (num + 1) % (start * 2)
                res += max(0, extra - start)
                start <<= 1
            return res

        def count_twos(num):
            res = 0
            start = 1
            power = 0
            while start <= num:
                res += (num + 1) // (start * 2) * (start) * (power)
                extra = (num + 1) % (start * 2)
                res += max(0, extra - start) * (power)
                start <<= 1
                power += 1
            return res

        def query(num):
            if num < 0:
                return 0
            num += 1
            l, r = 0, num
            res = num
            extra = 0
            while l <= r:
                p = (l + r) // 2
                ones = count_ones(p)
                if ones <= num:
                    res = p
                    extra = num - ones
                    l = p + 1
                else:
                    r = p - 1
            twos = count_twos(res)
            if extra:
                res += 1
                i = 0
                while extra:
                    if res & (1 << i) != 0:
                        extra -= 1
                        twos += i
                    i += 1
            return twos

        return [pow(2, query(y) - query(x - 1), mod) for x, y, mod in queries]

        # time O(n*log^2(m))
        # space O(1)
