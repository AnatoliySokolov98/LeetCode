import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> DNA = new HashMap<>();

        for (int i = 9; i < s.length(); i++) {
            String segment = s.substring(i - 9, i + 1);
            DNA.put(segment, DNA.getOrDefault(segment, 0) + 1);
            if (DNA.get(segment) == 2) {
                res.add(segment);
            }
        }
        return res;
    }
}
