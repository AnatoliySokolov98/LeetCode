import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : hand) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (int num : hand) {
            while (counts.get(num) != 0) {
                for (int i = 0; i < groupSize; i++) {
                    int curr = counts.getOrDefault(num + i, 0);
                    if (curr == 0) {
                        return false;
                    }
                    counts.put(num + i, curr - 1);
                }
            }
        }
        return true;
    }
}

// time O(nlogn)
// space O(n)