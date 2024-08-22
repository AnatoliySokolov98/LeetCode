function findComplement(num: number): number {
  let bits = 0;
  let res = num;
  while (num) {
    num >>= 1;
    bits <<= 1;
    bits += 1;
  }
  return bits - res;
}
