impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        let bytes = s.as_bytes();
        Self::palindrome_helper(bytes, 0, bytes.len() - 1, 0)
    }

    fn palindrome_helper(s: &[u8], mut left: usize, mut right: usize, errors: usize) -> bool {
        while left < right {
            if s[left] != s[right] {
                if errors == 1 {
                    return false;
                }
                return Self::palindrome_helper(s, left + 1, right, errors + 1)
                    || Self::palindrome_helper(s, left, right - 1, errors + 1);
            }
            left += 1;
            right -= 1;
        }
        true
    }
}
