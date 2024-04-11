function partitionString(s: string): number {
  const chars: Set<string> = new Set();
  let res = 0;
  for (let char of s) {
    if (chars.has(char)) {
      res++;
      chars.clear();
    }
    chars.add(char);
  }
  return res + 1;
}
