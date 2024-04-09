function maxNumberOfBalloons(text: string): number {
  const letterCounts: Map<string, number> = new Map();
  for (let letter of text) {
    letterCounts.set(letter, (letterCounts.get(letter) || 0) + 1);
  }
  let res = Infinity;
  for (let letter of "ban") {
    res = Math.min(letterCounts.get(letter) || 0, res);
  }
  res = Math.min(Math.floor((letterCounts.get("o") || 0) / 2), res);
  res = Math.min(Math.floor((letterCounts.get("l") || 0) / 2), res);
  return res;
}
