class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start > 0 && s.charAt(start - 1) != ' ') {
            start--;
        }
        return end - start + 1;
    }
}