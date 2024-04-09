import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> diss = new HashSet<>();
        for(int i = 1; i<= nums.length; i++) {
            diss.add(i);
        }
        for(int num: nums) {
            diss.remove(num);
        }
        return new ArrayList<>(diss);
    }
}