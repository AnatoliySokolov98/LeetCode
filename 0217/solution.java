import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<Integer>();
        for (int num: nums) {
            if(uniques.contains(num)) {
                return true;
            }
            uniques.add(num);
        }
        return false;
    }
}