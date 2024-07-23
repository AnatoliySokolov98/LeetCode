import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        Integer[] ints = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = nums[i];
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        Arrays.sort(ints, (a, b) -> {
            int freqA = counts.get(a);
            int freqB = counts.get(b);
            if (freqA == freqB) {
                return b - a;
            } else {
                return freqA - freqB;
            }
        });

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = ints[i];
        }
        return res;
    }
}

// time O(nlogn)
// space O(n)