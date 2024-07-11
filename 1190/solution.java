import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String reverseParentheses(String s) {
        Map<Integer, Integer> parens = new HashMap<>();
        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.removeLast();
                parens.put(i, j);
                parens.put(j, i);
            }
        }
        int direction = 1;
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && i < s.length()) {
            if (parens.containsKey(i)) {
                direction *= -1;
                i = parens.get(i) + direction;
            } else {
                res.append(s.charAt(i));
                i += direction;
            }
        }
        return res.toString();
    }
}

// time O(n)
// space O(n)