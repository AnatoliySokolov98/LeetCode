function maxScoreWords(
  words: string[],
  letters: string[],
  score: number[]
): number {
  let res = 0;
  let curr = 0;
  const letterCounts = new Array(26).fill(0);
  const wordCounts = words.map(() => new Array(26).fill(0));

  for (let c of letters) {
    letterCounts[c.charCodeAt(0) - "a".charCodeAt(0)]++;
  }

  for (let i = 0; i < words.length; i++) {
    for (let c of words[i]) {
      wordCounts[i][c.charCodeAt(0) - "a".charCodeAt(0)]++;
    }
  }

  function backtrack(i: number): void {
    if (i === wordCounts.length) {
      res = Math.max(res, curr);
      return;
    }

    let canBuild = true;
    for (let j = 0; j < wordCounts[i].length; j++) {
      if (wordCounts[i][j] > letterCounts[j]) {
        canBuild = false;
        break;
      }
    }

    if (canBuild) {
      for (let j = 0; j < wordCounts[i].length; j++) {
        letterCounts[j] -= wordCounts[i][j];
        curr += wordCounts[i][j] * score[j];
      }
      backtrack(i + 1);
      for (let j = 0; j < wordCounts[i].length; j++) {
        letterCounts[j] += wordCounts[i][j];
        curr -= wordCounts[i][j] * score[j];
      }
    }
    backtrack(i + 1);
  }

  backtrack(0);
  return res;
}
