function nthUglyNumber(n: number): number {
  const uglyNums = Array(n).fill(0);
  uglyNums[0] = 1;
  let twos = 0;
  let threes = 0;
  let fives = 0;

  for (let i = 1; i < n; i++) {
    uglyNums[i] = Math.min(
      uglyNums[twos] * 2,
      Math.min(uglyNums[threes] * 3, uglyNums[fives] * 5)
    );
    if (uglyNums[i] == uglyNums[twos] * 2) {
      twos++;
    }
    if (uglyNums[i] == uglyNums[threes] * 3) {
      threes++;
    }
    if (uglyNums[i] == uglyNums[fives] * 5) {
      fives++;
    }
  }
  return uglyNums[n - 1];
}
