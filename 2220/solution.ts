function minBitFlips(start: number, goal: number): number {
  let xor = start ^ goal;
  let res = 0;
  while (xor > 0) {
    res += xor & 1;
    xor >>= 1;
  }
  return res;
}
