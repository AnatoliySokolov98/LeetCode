function firstUniqChar(s: string): number {
  const counts = new Array(26).fill(0);
  for (let i = 0; i < s.length; i++) {
    counts[s[i].charCodeAt(0) - "a".charCodeAt(0)]++;
  }
  for (let i = 0; i < s.length; i++) {
    if (counts[s[i].charCodeAt(0) - "a".charCodeAt(0)] == 1) {
      return i;
    }
  }
  return -1;
}
