use rand::Rng;

struct Solution {
    prefix_sums: Vec<i32>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl Solution {
    fn new(w: Vec<i32>) -> Self {
        let mut prefix_sums = Vec::new();
        let mut total = 0;
        for item in w {
            total += item;
            prefix_sums.push(total);
        }
        return Solution { prefix_sums };
    }

    fn pick_index(&self) -> i32 {
        let total = *self.prefix_sums.last().unwrap();
        let mut rng = rand::thread_rng();
        let n = rng.gen_range(1..=(total));
        let mut res = 0;
        let (mut l, mut r) = (0, self.prefix_sums.len() - 1);
        while l <= r && r < self.prefix_sums.len() {
            let p = l + (r - l) / 2;
            if self.prefix_sums[p] >= n {
                res = p;
                if p == 0 {
                    break;
                }
                r = p.wrapping_sub(1);
            } else {
                l = p + 1;
            }
        }
        return res as i32;
    }
}
