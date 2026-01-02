use std::collections::HashMap;

impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        let mut res = i32::MAX;
        let mut locs: HashMap<i32, usize> = HashMap::new();
        for (i, v) in cards.iter().enumerate() {
            if let Some(&loc) = locs.get(v) {
                res = res.min((i - loc + 1) as i32);
            }

            locs.insert(*v, i);
        }
        if res == i32::MAX {
            return -1;
        } else {
            return res;
        }
    }
}
