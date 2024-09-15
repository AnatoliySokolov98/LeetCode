function findTheLongestSubstring(s: string): number {
  const vowel_to_bit = { a: 0, e: 1, i: 2, o: 3, u: 4 };
  let mask = 0;
  const locs = { 0: -1 };
  let res = 0;

  for (let i = 0; i < s.length; i++) {
    const char = s[i];
    if (char in vowel_to_bit) mask ^= 1 << vowel_to_bit[char];
    if (mask in locs) res = Math.max(res, i - locs[mask]);
    else locs[mask] = i;
  }
  return res;
}
