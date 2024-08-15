class Solution {
    public boolean makeEqual(String[] words) {
        int[] counts = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }
        }
        for (int num : counts) {
            if (num % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}