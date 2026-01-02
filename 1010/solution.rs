use std::collections::HashMap;

impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        let mut res = 0;
        let mut counts: HashMap<i32, i32> = HashMap::new();
        for t in time {
            let remainder = t % 60;
            let complement = (60 - remainder) % 60;
            if let Some(&count) = counts.get(&complement) {
            res += count;
            }
            *counts.entry(remainder).or_default() += 1;
        }
        return res;
    }
}

