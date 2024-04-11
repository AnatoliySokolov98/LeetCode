import java.util.List;
import java.util.ArrayList;

class Solution {
    public int calPoints(String[] operations) {
        List<Integer> stack = new ArrayList<>();
        for (String c : operations) {
            switch (c) {
                case "+":
                    stack.add(stack.getLast() + stack.get(stack.size() - 2));
                    break;
                case "D":
                    stack.add(stack.getLast() * 2);
                    break;
                case "C":
                    stack.removeLast();
                    break;
                default:
                    stack.add(Integer.parseInt(c));
            }
        }
        int res = 0;
        for (int num : stack) {
            res += num;
        }
        return res;
    }
}