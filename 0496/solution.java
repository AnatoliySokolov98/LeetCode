import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums2.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer>  locs = new HashMap<>();
        List<List<Integer>> stack = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
            System.out.println(stack);
            while(!stack.isEmpty() && stack.getLast().getLast() < nums2[i]) {
                res[stack.getLast().getFirst()] = nums2[i];
                stack.removeLast();
            }
            List<Integer> item = new ArrayList<>();
            item.add(nums2[i]);
            item.add(i);

            locs.put(nums2[i], i);
            stack.add(item);
        }
        int [] output = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            output[i] = res[locs.get(nums2[i])];
        }
        return output;
    }
}