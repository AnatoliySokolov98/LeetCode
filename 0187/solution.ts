function findRepeatedDnaSequences(s: string): string[] {
  const res = new Set<string>();
  const uniques = new Set<string>();
  for (let i = 0; i <= s.length - 10; i++) {
    const curr = s.slice(i, i + 10);
    if (res.has(curr)) continue;
    if (uniques.has(curr)) {
      res.add(curr);
    } else {
      uniques.add(curr);
    }
  }
  return [...res];
}
