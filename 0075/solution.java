import java.util.Map;
import java.util.HashMap;

class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int num = 0; num <= 2; num++) {
            int count = counts.getOrDefault(num, 0);
            for (int i = 0; i < count; i++) {
                nums[index++] = num;
            }
        }
    }
}