function tribonacci(n: number): number {
  if (n === 0) {
    return 0;
  }
  let [first, second, third] = [0, 1, 1];
  for (let i = 0; i < n - 2; i++) {
    [first, second, third] = [second, third, first + second + third];
  }
  return third;
}
