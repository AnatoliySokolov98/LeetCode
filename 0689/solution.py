class Solution:
    def maxSumOfThreeSubarrays(self, nums: list[int], k: int) -> list[int]:
        # Get the length of input array
        n = len(nums)

        # Calculate prefix sums for efficient subarray sum computation
        prefix_sum = [0] * (n + 1)
        for i in range(n):
            prefix_sum[i + 1] = prefix_sum[i] + nums[i]

        # Function to get sum of subarray starting at index i with length k
        def get_subarray_sum(i):
            return prefix_sum[i + k] - prefix_sum[i]

        # Arrays to store the maximum sum and corresponding index
        # left[i] stores the best starting index for one subarray in range [0,i]
        left_sum = [0] * n
        left = [0] * n
        curr_sum = get_subarray_sum(0)
        left_sum[k - 1] = curr_sum

        # Fill left array
        for i in range(k, n):
            curr_sum = get_subarray_sum(i - k + 1)
            if curr_sum > left_sum[i - 1]:
                left_sum[i] = curr_sum
                left[i] = i - k + 1
            else:
                left_sum[i] = left_sum[i - 1]
                left[i] = left[i - 1]

        # Arrays for right side
        # right[i] stores the best starting index for one subarray in range [i,n-k]
        right_sum = [0] * n
        right = [0] * n
        curr_sum = get_subarray_sum(n - k)
        right_sum[n - k] = curr_sum
        right[n - k] = n - k

        # Fill right array
        for i in range(n - k - 1, -1, -1):
            curr_sum = get_subarray_sum(i)
            if curr_sum >= right_sum[i + 1]:  # >= ensures lexicographically smallest
                right_sum[i] = curr_sum
                right[i] = i
            else:
                right_sum[i] = right_sum[i + 1]
                right[i] = right[i + 1]

        # Find the middle array that gives maximum sum combined with
        # best possible left and right arrays
        max_sum = 0
        result = [-1, -1, -1]

        # Try each possible middle array
        for i in range(k, n - 2 * k + 1):
            mid_sum = get_subarray_sum(i)
            total = left_sum[i - 1] + mid_sum + right_sum[i + k]
            if total > max_sum:
                max_sum = total
                result = [left[i - 1], i, right[i + k]]

        return result

        # time O(n)
        # space O(n)
