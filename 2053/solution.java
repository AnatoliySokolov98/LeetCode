import java.util.HashMap;
import java.util.Map;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String s : arr) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }
        for (String s : arr) {
            if (counts.get(s) == 1) {
                k--;
            }
            if (k == 0) {
                return s;
            }
        }
        return "";
    }
}

// time O(n)
// space O(n)