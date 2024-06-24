import java.util.ArrayDeque;

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        ArrayDeque<Integer> flips = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!flips.isEmpty() && flips.getFirst() < i) {
                flips.removeFirst();
            }
            int curr = (nums[i] + flips.size()) % 2;
            if (curr == 0) {
                if (i > nums.length - k) {
                    return -1;
                }
                res++;
                flips.add(i + k - 1);
            }
        }
        return res;
    }
}

// time O(n)
// space O(n)