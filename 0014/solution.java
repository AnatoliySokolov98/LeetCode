class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            for(int j = 0; j < strs[i].length(); j++) {
                if (j >= prefix.length() || strs[i].charAt(j) != prefix.charAt(j)) {
                    prefix = strs[i].substring(0, j);
                    break;
                }
            }
            if (prefix.length() > strs[i].length()) {
                prefix = strs[i];
            }
        }
        return prefix;
    }
}