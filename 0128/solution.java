import java.util.Set;
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> streak = new HashSet<>();
        for (int num : nums) {
            streak.add(num);
        }

        int maxStreak = 0;
        for (int num : nums) {
            // Start a new sequence only if 'num' is the beginning of a sequence
            if (!streak.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (streak.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }
        return maxStreak;
    }
}
