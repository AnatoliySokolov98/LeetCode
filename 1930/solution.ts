function countPalindromicSubsequence(s: string): number {
  const left = new Map<string, number>();
  const right = new Map<string, number>();
  let res = 0;
  for (let i = 0; i < s.length; i++) {
    if (left.has(s[i])) {
      right.set(s[i], i);
    } else {
      left.set(s[i], i);
    }
  }
  for (const key of right.keys()) {
    const chars = new Set<string>();
    for (let i = left.get(key)! + 1; i < right.get(key)!; i++) {
      chars.add(s[i]);
    }
    res += chars.size;
  }
  return res;
}
