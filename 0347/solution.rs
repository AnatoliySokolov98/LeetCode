use std::collections::HashMap;

impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let k: usize = k as usize;
        let l = nums.len();
        let mut buckets: Vec<Vec<i32>> = vec![vec![]; l + 1];
        let mut counts: HashMap<i32, i32> = HashMap::new();
        for num in nums {
            *counts.entry(num).or_default() += 1;
        }

        for (key, val) in counts {
            buckets[val as usize].push(key);
        }

        let mut res: Vec<i32> = Vec::with_capacity(k);
        for bucket in buckets.iter().rev() {
            for &item in bucket {
                res.push(item);
                if res.len() == k {
                    return res;
                }
            }
        }
        return res;
    }
}
