class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> uniques = new HashSet<>();
        for (int num: nums) {
            if (num < k) {
                return -1;
            }
            if (num > k) {
                uniques.add(num);
            } 
        }
        return uniques.size();
    }
}

// time O(n)
// space O(n)