function minimumDeletions(s: string): number {
  let leftB = 0;
  let rightA = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] == "b") {
      leftB++;
    }
  }
  let res = Math.min(leftB, s.length - leftB);
  for (let i = s.length - 1; i >= 0; i--) {
    leftB -= s[i] == "b" ? 1 : 0;
    res = Math.min(res, leftB + rightA);
    rightA += s[i] == "a" ? 1 : 0;
  }
  return res;
}
