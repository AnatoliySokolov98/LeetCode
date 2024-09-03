function getLucky(s: string, k: number): number {
  let res = 0;
  for (const char of s) {
    let num = char.charCodeAt(0) - "a".charCodeAt(0) + 1;
    while (num) {
      res += num % 10;
      num = Math.floor(num / 10);
    }
  }
  k -= 1;
  while (k) {
    let new_res = 0;
    while (res) {
      new_res += res % 10;
      res = Math.floor(res / 10);
    }
    k -= 1;
    res = new_res;
  }
  return res;
}
