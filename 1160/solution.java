class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCounts = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charCounts[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        for (String word : words) {
            int[] letterCounts = new int[26];
            for (int i = 0; i < word.length(); i++) {
                letterCounts[word.charAt(i) - 'a']++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (charCounts[i] < letterCounts[i]) {
                    valid = false;
                    break;
                }
            }
            res += valid ? word.length() : 0;
        }
        return res;
    }
}