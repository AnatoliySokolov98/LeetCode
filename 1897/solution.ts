function makeEqual(words: string[]): boolean {
  const counts = new Array(26).fill(0);
  for (const word of words) {
    for (const char of word) {
      counts[char.charCodeAt(0) - "a".charCodeAt(0)]++;
    }
  }
  for (const num of counts) {
    if (num % words.length != 0) {
      return false;
    }
  }
  return true;
}
