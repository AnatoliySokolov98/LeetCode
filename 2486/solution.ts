function appendCharacters(s: string, t: string): number {
  let tIndex = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] == t[tIndex]) {
      tIndex++;
      if (tIndex == t.length) {
        return 0;
      }
    }
  }
  return t.length - tIndex;
}
