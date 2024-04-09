import java.util.HashMap;
import java.util.Map;

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> counts = new HashMap<>();

        for (int[] rectangle : rectangles) {
            double dim = (double) rectangle[0] / rectangle[1];
            counts.put(dim, counts.getOrDefault(dim, 0) + 1);
        }
        long res = 0;
        for (Integer val : counts.values()) {
            res += (long) val * (val - 1) / 2;
        }
        return res;
    }
}
