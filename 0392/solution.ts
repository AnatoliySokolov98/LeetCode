function isSubsequence(s: string, t: string): boolean {
  let left = 0;
  for (let char of t) {
    if (left === s.length) {
      return true;
    }
    if (s[left] === char) {
      left++;
    }
  }
  return left === s.length;
}
