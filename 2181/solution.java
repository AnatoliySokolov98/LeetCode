import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        for (int num : nums2) {
            set2.add(num);
        }
        for (int item : set1) {
            if (!set2.contains(item)) {
                res1.add(item);
            }
        }
        for (int item : set2) {
            if (!set1.contains(item)) {
                res2.add(item);
            }
        }
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(res1);
        finalList.add(res2);
        return finalList;
    }
}