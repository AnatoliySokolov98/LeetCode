import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> ps = new HashMap<>();
        Map<String, Character> sp = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = pattern.charAt(i);
            ps.computeIfAbsent(c, k-> word);
            sp.computeIfAbsent(word, k-> c);
            if(!ps.get(c).equals(word)) {
                return false;
            }
            if(sp.get(word) != c) {
                return false;
            }
        }
        return true;
    }
}