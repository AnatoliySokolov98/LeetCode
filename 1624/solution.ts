function maxLengthBetweenEqualCharacters(s: string): number {
  const locs = new Array(26).fill(-1);
  let res = -1;
  for (let i = 0; i < s.length; i++) {
    let c = s[i].charCodeAt(0) - "a".charCodeAt(0);
    if (locs[c] != -1) {
      res = Math.max(i - locs[c] - 1, res);
    } else {
      locs[c] = i;
    }
  }
  return res;
}
