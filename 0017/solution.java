import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();
        Map<Character, String> phone = new HashMap<>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "nmo");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(digits, phone, 0, builder, res);
        return res;
    }

    private void backtrack(String digits, Map<Character, String> phone, int i, StringBuilder builder,
            List<String> res) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        String curr = phone.get(digits.charAt(i));

        for (char c : curr.toCharArray()) {
            builder.append(c);
            backtrack(digits, phone, i + 1, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}