function minimumPushes(word: string): number {
  const counts = Array.from({ length: 26 }, () => 0);
  for (let i = 0; i < word.length; i++) {
    counts[word.charCodeAt(i) - "a".charCodeAt(0)]++;
  }
  counts.sort((a, b) => b - a);
  let res = 0;
  for (let i = 0; i <= 25; i++) {
    res += Math.ceil((i + 1) / 8) * counts[i];
  }
  return res;
}
