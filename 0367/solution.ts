function isPerfectSquare(num: number): boolean {
  let l = 1,
    r = num;
  while (l <= r) {
    let p = Math.floor((l + r) / 2);
    if (p ** 2 === num) {
      return true;
    }
    if (p ** 2 > num) {
      r = p - 1;
    } else {
      l = p + 1;
    }
  }
  return false;
}
