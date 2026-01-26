impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        let mut res: Vec<Vec<i32>> = Vec::new();
        let mut curr: Vec<i32> = Vec::new();

        Self::backtrack(&mut res, &mut curr, n, k as usize, 1);
        return res;
    }

    fn backtrack(res: &mut Vec<Vec<i32>>, curr: &mut Vec<i32>, n: i32, k: usize, i: i32) {
        if curr.len() == k {
            res.push(curr.clone());
            return;
        }
        if i > n {
            return;
        }
        curr.push(i);
        Self::backtrack(res, curr, n, k, i + 1);
        curr.pop();
        Self::backtrack(res, curr, n, k, i + 1);
    }
}
