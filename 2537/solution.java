class Solution {
    public long countGood(int[] nums, int k) {
        int l = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        long pairs = 0;
        long res = 0;
        for (int r = 0; r < nums.length; r++) {
            int count = counts.getOrDefault(nums[r], 0);
            pairs += count;
            counts.put(nums[r], count + 1);
            while (pairs - (counts.get(nums[l]) - 1) >= k) {
                int leftCount = counts.get(nums[l]);
                counts.put(nums[l], leftCount - 1);
                l++;
                pairs -= leftCount - 1;
            }
            if (pairs >= k) {
                res += l + 1;
            }
        }
        return res;
    }
}

// time O(n)
// space O(n)