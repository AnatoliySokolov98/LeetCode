function hasAllCodes(s: string, k: number): boolean {
  const codes = new Set<string>();
  for (let i = 0; i <= s.length - k; i++) {
    codes.add(s.slice(i, i + k));
  }
  return codes.size === Math.pow(2, k);
}
