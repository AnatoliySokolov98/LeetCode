class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32]; // To count each bit position
        int res = Integer.MAX_VALUE;
        int left = 0;

        // Sliding window approach
        for (int right = 0; right < nums.length; right++) {
            addBits(nums[right], bits);

            // Shrink the window from the left while the condition is satisfied
            while (currentBitSum(bits) >= k && left <= right) {
                res = Math.min(res, right - left + 1);
                subtractBits(nums[left], bits);
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // Function to add bits of a number to the bit count array
    private void addBits(int num, int[] bits) {
        int i = 0;
        while (num > 0) {
            bits[i] += num & 1;
            num >>= 1;
            i++;
        }
    }

    // Function to subtract bits of a number from the bit count array
    private void subtractBits(int num, int[] bits) {
        int i = 0;
        while (num > 0) {
            bits[i] -= num & 1;
            num >>= 1;
            i++;
        }
    }

    // Function to reconstruct the current bitwise OR value
    private int currentBitSum(int[] bits) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] > 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}

// time O(n)
// space O(1)