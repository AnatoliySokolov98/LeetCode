import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parens = new HashMap<>();
        parens.put('(', ')');
        parens.put('[', ']');
        parens.put('{', '}');
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("({[".indexOf(c) != -1) {
                builder.append(c);
            } else if (!builder.isEmpty() && parens.get(builder.charAt(builder.length() - 1)) == c) {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                return false;
            }
        }
        return builder.isEmpty();
    }
}