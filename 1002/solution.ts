function commonChars(words: string[]): string[] {
  const ALPHABET_SIZE = 26;
  const prev = new Array(ALPHABET_SIZE).fill(0);

  for (const char of words[0]) {
    prev[char.charCodeAt(0) - "a".charCodeAt(0)]++;
  }

  for (let i = 1; i < words.length; i++) {
    const curr = new Array(ALPHABET_SIZE).fill(0);
    for (const char of words[i]) {
      curr[char.charCodeAt(0) - "a".charCodeAt(0)]++;
    }
    for (let j = 0; j < ALPHABET_SIZE; j++) {
      prev[j] = Math.min(curr[j], prev[j]);
    }
  }

  const res: string[] = [];
  for (let i = 0; i < ALPHABET_SIZE; i++) {
    for (let j = 0; j < prev[i]; j++) {
      res.push(String.fromCharCode(i + "a".charCodeAt(0)));
    }
  }

  return res;
}
