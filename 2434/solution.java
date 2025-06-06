class Solution {
    public String robotWithString(String s) {
        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charCounts[currentChar - 'a']--;
            stack.append(currentChar);
            while (!stack.isEmpty()) {
                char topChar = stack.charAt(stack.length() - 1);
                int topIndex = topChar - 'a';

                boolean hasSmaller = false;
                for (int j = 0; j < topIndex; j++) {
                    if (charCounts[j] > 0) {
                        hasSmaller = true;
                        break;
                    }
                }

                if (hasSmaller) {
                    break;
                }

                result.append(topChar);
                stack.deleteCharAt(stack.length() - 1);
            }
        }
        return result.toString();
    }
}

// time O(uniqueChars * n)
// space O(n)