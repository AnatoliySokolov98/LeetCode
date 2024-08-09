function countCharacters(words: string[], chars: string): number {
  const totalCounts = new Map<string, number>();
  for (const char of chars) {
    totalCounts.set(char, (totalCounts.get(char) ?? 0) + 1);
  }
  let res = 0;
  for (const word of words) {
    const letterCounts = new Map<string, number>();
    for (const char of word) {
      letterCounts.set(char, (letterCounts.get(char) ?? 0) + 1);
    }
    let valid = true;
    for (const key of letterCounts.keys()) {
      if (
        !totalCounts.get(key) ||
        letterCounts.get(key)! > totalCounts.get(key)!
      ) {
        valid = false;
        break;
      }
    }
    res += valid ? word.length : 0;
  }
  return res;
}
