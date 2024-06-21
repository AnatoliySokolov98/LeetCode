function maxSatisfied(
  customers: number[],
  grumpy: number[],
  minutes: number
): number {
  let curr = 0;
  for (let i = 0; i < customers.length; i++) {
    curr += grumpy[i] == 1 ? 0 : customers[i];
  }
  let res = curr;
  for (let i = 0; i < customers.length; i++) {
    curr += grumpy[i] == 1 ? customers[i] : 0;
    if (i >= minutes) {
      curr -= grumpy[i - minutes] == 1 ? customers[i - minutes] : 0;
    }
    res = Math.max(res, curr);
  }
  return res;
}
