import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int prevBig = arrays.get(0).get(arrays.get(0).size() - 1);
        int prevSmall = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size(); i++) {
            int currBig = arrays.get(i).get(arrays.get(i).size() - 1);
            int currSmall = arrays.get(i).get(0);
            res = Math.max(res, currBig - prevSmall);
            res = Math.max(res, prevBig - currSmall);
            prevBig = Math.max(prevBig, currBig);
            prevSmall = Math.min(prevSmall, currSmall);
        }
        return res;
    }
}

// time O(n)
// space O(1)