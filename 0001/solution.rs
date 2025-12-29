impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut cache: HashMap<i32, i32> = HashMap::new();
        for (i, &v) in nums.iter().enumerate() {
            let complement = target - v;
            if let Some(&index) = cache.get(&complement) {
                return vec![index, i as i32];
            }
            cache.insert(v, i as i32);
        }
        return vec![];
    }
}
