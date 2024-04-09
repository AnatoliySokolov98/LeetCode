function wordPattern(pattern: string, s: string): boolean {
  const letters: string[] = pattern.split("");
  const words: string[] = s.split(" ");
  if (letters.length !== words.length) {
    return false;
  }
  const pMap: Map<string, string> = new Map();
  const sMap: Map<string, string> = new Map();

  for (let i = 0; i < letters.length; i++) {
    if (pMap.has(letters[i]) && pMap.get(letters[i]) !== words[i]) {
      return false;
    }
    pMap.set(letters[i], words[i]);

    if (sMap.has(words[i]) && sMap.get(words[i]) !== letters[i]) {
      return false;
    }
    sMap.set(words[i], letters[i]);
  }
  return true;
}
