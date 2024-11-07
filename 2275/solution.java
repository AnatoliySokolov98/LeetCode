class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCounts = new int[32];
        for (int num : candidates) {
            int i = 0;
            while (num != 0) {
                bitCounts[i] += num & 1;
                num >>= 1;
                i++;
            }
        }
        int res = 0;
        for (int num : bitCounts) {
            res = Math.max(res, num);
        }
        return res;
    }
}

// O(n)
// O(1 )