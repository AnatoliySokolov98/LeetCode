class Solution {
    public int compareVersion(String version1, String version2) {
        int V1 = version1.length();
        int V2 = version2.length();
        int i = 0;
        int j = 0;
        while (i < V1 || j < V2) {
            int num1 = 0;
            while (i < V1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (int) (version1.charAt(i++) - '0');
            }
            i++;
            int num2 = 0;
            while (j < V2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (int) (version2.charAt(j++) - '0');
            }
            j++;

            if (num1 > num2) {
                return 1;
            }

            if (num2 > num1) {
                return -1;
            }
        }
        return 0;
    }
}

// time O(m + n)
// space O(1)