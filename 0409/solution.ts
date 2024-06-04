function longestPalindrome(s: string): number {
  const counts = new Map<string, number>();
  for (let char of s) {
    counts.set(char, (counts.get(char) || 0) + 1);
  }
  let pairs = 0;
  let extra = false;
  for (const value of counts.values()) {
    pairs += Math.floor(value / 2);
    extra = extra || value % 2 == 1;
  }
  return pairs * 2 + (extra ? 1 : 0);
}
