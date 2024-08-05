function kthDistinct(arr: string[], k: number): string {
  const counts = new Map<String, number>();
  for (const s of arr) {
    counts.set(s, (counts.get(s) ?? 0) + 1);
  }

  for (const s of arr) {
    if (counts.get(s) === 1) {
      k--;
    }
    if (k === 0) {
      return s;
    }
  }
  return "";
}
