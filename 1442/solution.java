import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countTriplets(int[] arr) {
        Map<Integer, int[]> counts = new HashMap<>();
        int xor = 0;
        int res = 0;
        counts.put(0, new int[] { 1, 0 });
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (counts.containsKey(xor)) {
                int[] value = counts.get(xor);
                int count = value[0];
                int indexTotal = value[1];
                res += (i * count) - indexTotal;
                indexTotal += i + 1;
                count++;
                counts.put(xor, new int[] { count, indexTotal });
            } else {
                counts.put(xor, new int[] { 1, i + 1 });
            }
        }
        return res;
    }
}

// time O(n)
// space O(n)
