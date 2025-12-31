impl Solution {
    pub fn valid_word_abbreviation(word: &str, abbr: &str) -> bool {
        let word = word.as_bytes();
        let mut abbr = abbr.as_bytes().iter().peekable();

        let mut word_idx = 0;
        while let Some(&ch) = abbr.next() {
            if ch.is_ascii_alphabetic() {
                if word.get(word_idx) != Some(&ch) {
                    return false;
                }
                word_idx += 1;
            } else {
                // Leading zeros are invalid
                if ch == b'0' {
                    return false;
                }
                let mut skip = (ch - b'0') as usize;
                while abbr.peek().is_some_and(|c| c.is_ascii_digit()) {
                    skip = skip * 10 + (abbr.next().unwrap() - b'0') as usize;
                }
                word_idx += skip;
            }
        }
        word_idx == word.len()
    }
}
