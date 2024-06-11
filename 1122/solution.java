import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[arr1.length];
        int i = 0;

        for (int num : arr2) {
            if (counts.containsKey(num)) {
                int count = counts.get(num);
                for (int j = 0; j < count; j++) {
                    res[i++] = num;
                }
                counts.remove(num);
            }
        }

        List<Integer> extra = new ArrayList<>();
        for (int num : arr1) {
            if (counts.containsKey(num)) {
                extra.add(num);
            }
        }

        Collections.sort(extra);
        for (int num : extra) {
            res[i++] = num;
        }

        return res;
    }
}

// time O(nlogn + m)
// space O(n)
