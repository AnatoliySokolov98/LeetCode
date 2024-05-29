function numSteps(s: string): number {
  let res = 0;
  let carry = 0;

  for (let i = s.length - 1; i > 0; i--) {
    const curr = parseInt(s[i]) + carry;
    if (curr == 2) {
      res += 1;
      carry = 1;
    } else if (curr == 1) {
      carry = 1;
      res += 2;
    } else {
      carry = 0;
      res += 1;
    }
  }
  return res + carry;
}
