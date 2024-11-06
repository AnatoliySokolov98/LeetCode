class Solution:
    def canSortArray(self, nums: list[int]) -> bool:
        def calculate_bits(num):
            count = 0
            while num:
                count += num & 1
                num >>= 1
            return count

        bits = [[num, calculate_bits(num)] for num in nums]

        segments = []
        curr_min = curr_max = bits[0][0]
        curr_bit_count = bits[0][1]

        for i in range(1, len(bits)):
            num, bit_count = bits[i]
            if bit_count != curr_bit_count:
                segments.append([curr_min, curr_max])
                curr_min = curr_max = num
                curr_bit_count = bit_count
            else:
                curr_min = min(curr_min, num)
                curr_max = max(curr_max, num)

        segments.append([curr_min, curr_max])

        for i in range(len(segments) - 1):
            _, max_in_current = segments[i]
            min_in_next, _ = segments[i + 1]
            if max_in_current > min_in_next:
                return False

        return True
