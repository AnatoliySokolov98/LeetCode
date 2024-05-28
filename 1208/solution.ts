function equalSubstring(s: string, t: string, maxCost: number): number {
  let res = 0;
  let currCost = 0;
  let l = 0;
  for (let r = 0; r < t.length; r++) {
    currCost += Math.abs(t.charCodeAt(r) - s.charCodeAt(r));
    while (currCost > maxCost) {
      currCost -= Math.abs(t.charCodeAt(l) - s.charCodeAt(l++));
    }
    res = Math.max(res, r - l + 1);
  }
  return res;
}
