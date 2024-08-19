function minSteps(n: number): number {
  let factor = 2;
  let res = 0;
  let root = Math.ceil(Math.sqrt(n));
  while (factor <= root) {
    while (n % factor == 0) {
      res += factor;
      n /= factor;
    }
    factor += 1;
  }
  return n == 1 ? res : res + n;
}
