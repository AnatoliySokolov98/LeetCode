function maxScore(s: string): number {
  let ones = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] == "1") {
      ones++;
    }
  }
  let zeroes = 0;
  let res = 0;
  for (let i = 0; i < s.length - 1; i++) {
    if (s[i] == "1") {
      ones--;
    } else {
      zeroes++;
    }
    res = Math.max(res, zeroes + ones);
  }
  return res;
}
