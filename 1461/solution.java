import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> codes = new HashSet<String>();
        for (int i = 0; i <= s.length() - k; i++) {
            codes.add(s.substring(i, i + k));
        }
        return codes.size() == Math.pow(2, k);
    }
}