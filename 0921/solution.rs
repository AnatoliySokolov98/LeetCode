impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        let mut res = 0;
        let mut opens = 0;
        for c in s.chars() {
            if c == '(' {
                opens += 1;
            } else if c == ')' {
                if opens > 0 {
                    opens -= 1;
                } else {
                    res += 1;
                }
            }
        }
        return res + opens;
    }
}
