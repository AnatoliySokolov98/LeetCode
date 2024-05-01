class Solution {
    public String reversePrefix(String word, char ch) {
        char[] res = word.toCharArray();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == ch) {
                int l = 0;
                int r = i;
                while (l < r) {
                    char temp = res[l];
                    res[l] = res[r];
                    res[r] = temp;
                    l++;
                    r--;
                }
                break;
            }
        }
        return new String(res);
    }
}

// time O(n)
// space O(n)