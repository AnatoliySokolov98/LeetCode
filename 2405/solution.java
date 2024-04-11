import java.util.Set;
import java.util.HashSet;

class Solution {
    public int partitionString(String s) {
        int res = 0;
        Set<Character> uniques = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (uniques.contains(s.charAt(i))) {
                res++;
                uniques.clear();
            }
            uniques.add(s.charAt(i));
        }
        return res + 1;
    }
}