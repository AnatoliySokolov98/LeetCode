function arrangeCoins(n: number): number {
  let res = 1;
  let left = 1,
    right = n;

  while (left <= right) {
    const pivot = Math.floor((left + right) / 2);
    const coins = (pivot * (pivot + 1)) / 2;
    if (coins === n) {
      return pivot;
    }
    if (coins < n) {
      res = pivot;
      left = pivot + 1;
    } else {
      right = pivot - 1;
    }
  }
  return res;
}
