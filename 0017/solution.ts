function letterCombinations(digits: string): string[] {
  if (digits.length == 0) return [];
  const letters: Record<string, string> = {
    2: "abc",
    3: "def",
    4: "ghi",
    5: "jkl",
    6: "mno",
    7: "pqrs",
    8: "tuv",
    9: "wxyz",
  };
  const res: string[] = [];
  const curr: string[] = [];

  const backtrack = (index: number) => {
    if (index === digits.length) {
      res.push(curr.join(""));
      return;
    }
    const word = letters[digits[index]];
    for (let i = 0; i < word.length; i++) {
      curr.push(word[i]);
      backtrack(index + 1);
      curr.pop();
    }
  };
  backtrack(0);
  return res;
}
