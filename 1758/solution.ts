function minOperations(s: string): number {
  let res1 = 0;
  let res2 = 0;
  for (let i = 0; i < s.length; i++) {
    if (i % 2 == parseInt(s[i])) {
      res1++;
    } else {
      res2++;
    }
  }
  return Math.min(res1, res2);
}
