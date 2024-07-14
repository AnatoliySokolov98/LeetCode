import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String countOfAtoms(String formula) {
        // Deque to keep track of nested scopes defined by parentheses
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        // Initialize the stack with an empty map
        stack.push(new HashMap<>());

        int i = 0;
        int n = formula.length();

        while (i < n) {
            if (formula.charAt(i) == '(') {
                // When encountering '(', push a new scope to the stack
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                // When encountering ')', process the scope
                i++;
                int start = i;
                // Read the number following ')'
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int val = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                // Pop the top scope and multiply its elements by the value
                Map<String, Integer> top = stack.pop();
                for (String key : top.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + top.get(key) * val);
                }
            } else {
                // Process element names and their counts
                int start = i;
                i++;
                // Read the element name
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(start, i);
                start = i;
                // Read the count of the element
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int val = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                // Add the element and its count to the current scope
                stack.peek().put(element, stack.peek().getOrDefault(element, 0) + val);
            }
        }

        // Prepare the result by sorting elements and concatenating their counts
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> finalCount = stack.pop();
        List<String> elements = new ArrayList<>(finalCount.keySet());
        Collections.sort(elements);
        for (String element : elements) {
            sb.append(element);
            int count = finalCount.get(element);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }
}

// time O(N^2)
// space O(N)