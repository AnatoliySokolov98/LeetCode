import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
       if(s.length() != t.length()) return false;
       Map<Character, Character> ss = new HashMap<>();
       Map<Character, Character> tt = new HashMap<>();
       for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            ss.put(sChar, ss.getOrDefault(sChar, tChar));
            tt.put(tChar, tt.getOrDefault(tChar, sChar));
            if(ss.get(sChar) != tChar || tt.get(tChar) != sChar) {
                return false;
            }
       }
       return true;
    }
}