import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(!res.containsKey(sortedString)) {  
                res.put(sortedString, new ArrayList<>());
            }
            res.get(sortedString).add(str);
        }
        List<List<String>> output = new ArrayList<>();
        for(List<String> val: res.values()) {
            output.add(val);
        }
        return output;
    }
}