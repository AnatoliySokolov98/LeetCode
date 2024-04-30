function wonderfulSubstrings(word: string): number {
  const counts = new Array(1024).fill(0);
  let mask = 0;
  counts[0] = 1;
  let res = 0;
  for (let i = 0; i < word.length; i++) {
    mask ^= 1 << (word.charCodeAt(i) - "a".charCodeAt(0));
    res += counts[mask];
    for (let j = 0; j < 10; j++) {
      const newMask = mask ^ (1 << j);
      res += counts[newMask];
    }
    counts[mask]++;
  }
  return res;
}
