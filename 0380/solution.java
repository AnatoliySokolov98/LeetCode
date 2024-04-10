import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class RandomizedSet {
    Random random;
    Map<Integer, Integer> locs;
    List<Integer> nums;

    public RandomizedSet() {
        random = new Random();
        locs = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (locs.containsKey(val))
            return false;
        nums.add(val);
        locs.put(val, nums.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!locs.containsKey(val))
            return false;
        int last = nums.getLast();
        int remove_loc = locs.get(val);
        locs.put(last, remove_loc);
        locs.remove(val);
        nums.set(remove_loc, last);
        nums.removeLast();
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }
}
