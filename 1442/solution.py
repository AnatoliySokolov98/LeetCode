class Solution:
    def countTriplets(self, arr: list[int]) -> int:
        counts = {0: [0, 1]}
        xor = 0
        res = 0
        for i, v in enumerate(arr):
            xor ^= v
            if xor in counts:
                total_index, count = counts[xor]
                res += (i * count) - total_index
                total_index += i + 1
                count += 1
                counts[xor] = [total_index, count]
            else:
                counts[xor] = [i + 1, 1]
        return res
