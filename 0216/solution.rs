impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        let k = k as usize;
        let mut res = Vec::<Vec<i32>>::new();
        let mut curr = Vec::<i32>::new();
        fn backtrack(i: i32, res: &mut Vec<Vec<i32>>, curr: &mut Vec<i32>, k: usize, n: i32) {
            if curr.len() == k {
                let total: i32 = curr.iter().sum();
                if total == n {
                    res.push(curr.clone());
                }
                return;
            }
            if i == 10 {
                return;
            }
            curr.push(i);
            backtrack(i + 1, res, curr, k, n);
            curr.pop();
            backtrack(i + 1, res, curr, k, n);
        }
        backtrack(1, &mut res, &mut curr, k, n);
        return res;
    }
}
