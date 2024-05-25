function wordBreak(s: string, wordDict: string[]): string[] {
  const res: Array<string> = [];
  const curr: Array<string> = [];
  const words = new Set(wordDict);
  const backtrack = (i: number): void => {
    if (i == s.length) {
      res.push(curr.join(" "));
      return;
    }
    for (let j = i; j < s.length; j++) {
      const word = s.slice(i, j + 1);
      if (words.has(word)) {
        curr.push(word);
        backtrack(j + 1);
        curr.pop();
      }
    }
  };
  backtrack(0);
  return res;
}
