function findAnagrams(s: string, p: string): number[] {
  const pChars: Record<string, number> = {};
  const sChars: Record<string, number> = {};
  for (let char of p) {
    pChars[char] = (pChars[char] || 0) + 1;
  }
  let matches = Object.keys(pChars).length;
  let left = 0;
  const res: number[] = [];
  const P = p.length;
  for (let right = 0; right < s.length; right++) {
    const char = s[right];
    sChars[char] = (sChars[char] || 0) + 1;
    if (sChars[char] === pChars[char]) {
      matches--;
    }
    if (right - left + 1 > P) {
      if (pChars[s[left]] && pChars[s[left]] === sChars[s[left]]) {
        matches++;
      }
      sChars[s[left]]--;
      left++;
    }
    if (right - left + 1 === P && matches === 0) {
      res.push(left);
    }
  }
  return res;
}
