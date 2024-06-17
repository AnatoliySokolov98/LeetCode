function judgeSquareSum(c: number): boolean {
  const root = Math.sqrt(c);
  for (let a = 0; a <= root; a++) {
    const b = Math.sqrt(c - a * a);
    if (b === Math.floor(b)) {
      return true;
    }
  }
  return false;
}
