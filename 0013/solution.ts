function romanToInt(s: string): number {
  const entries = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
    IV: 4,
    IX: 9,
    XL: 40,
    XC: 90,
    CD: 400,
    CM: 900,
  };
  const symbols = new Map<string, number>(Object.entries(entries));
  let res = 0;
  for (let i = 0; i < s.length; i++) {
    if (symbols.has(s.slice(i, i + 2))) {
      res += symbols.get(s.slice(i, i + 2))!;
      i++;
    } else {
      res += symbols.get(s[i])!;
    }
  }
  return res;
}
