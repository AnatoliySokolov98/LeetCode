use std::collections::HashMap;

impl Solution {
    pub fn max_sub_array_len(nums: Vec<i32>, k: i32) -> i32 {
        let mut totals: HashMap<i32, i32> = HashMap::new();
        totals.insert(0, -1);
        let mut res: i32 = 0;
        let mut total = 0;
        for (i, &v) in nums.iter().enumerate() {
            total += v;
            let complement = total - k;
            if let Some(&index) = totals.get(&complement) {
                res = res.max((i as i32) - index);
            }
            if !totals.contains_key(&total) {
                totals.insert(total, i as i32);
            }
        }
        return res;
    }
}
