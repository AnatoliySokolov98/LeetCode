import java.util.Map;
import java.util.HashMap;

class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> counter = new HashMap<>();
        for(int i = 0; i < text.length(); i++) {
            counter.put(text.charAt(i), counter.getOrDefault(text.charAt(i), 0) + 1);
        }

        int res = Integer.MAX_VALUE;
        int[] counts = {
                counter.getOrDefault('b', 0),
                counter.getOrDefault('l', 0) / 2,
                counter.getOrDefault('o', 0) / 2,
                counter.getOrDefault('n',0)
        };
        for(int count: counts) {
            res = Math.min(count, res);
        }
        return res;
    }
}