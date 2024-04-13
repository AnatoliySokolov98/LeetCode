function mySqrt(x: number): number {
  if (x <= 1) {
    return x;
  }

  let res = 1,
    left = 0,
    right = Math.floor(x / 2);

  while (left <= right) {
    const pivot = Math.floor((left + right) / 2);
    const square = pivot * pivot;
    if (square === x) {
      return pivot;
    }
    if (square < x) {
      res = pivot;
      left = pivot + 1;
    } else {
      right = pivot - 1;
    }
  }
  return res;
}
