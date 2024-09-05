function missingRolls(rolls: number[], mean: number, n: number): number[] {
  let knownRollTotal = 0;
  for (const roll of rolls) {
    knownRollTotal += roll;
  }
  const meanRollTotal = mean * (n + rolls.length);
  const nRollTotal = meanRollTotal - knownRollTotal;
  if (nRollTotal < n || nRollTotal > 6 * n) {
    return [];
  }
  const val = Math.floor(nRollTotal / n);
  const extra = nRollTotal % n;
  const res = Array(n).fill(0);
  for (let i = 0; i < res.length; i++) {
    res[i] = val + (i < extra ? 1 : 0);
  }
  return res;
}
