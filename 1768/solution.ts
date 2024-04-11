function mergeAlternately(word1: string, word2: string): string {
  const res: Array<string> = [];
  let i = 0,
    j = 0;
  while (i < word1.length || j < word2.length) {
    if (i < word1.length) {
      res.push(word1[i++]);
    }
    if (j < word2.length) {
      res.push(word2[j++]);
    }
  }
  return res.join("");
}
