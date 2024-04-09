import java.util.Map;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cuts = new HashMap<>();
        for(List<Integer> row: wall) {
            int total = 0;
            for(int i = 0; i < row.size() - 1; i++) {
                total += row.get(i);
                cuts.put(total, cuts.getOrDefault(total, 0) + 1);
            }
        }
        int res = 0;
        for(int value: cuts.values()) {
            res = Math.max(value, res);
        }
        return wall.size() - res;
    }
}