function findRelativeRanks(score: number[]): string[] {
  const S = score.length;
  const sortedScore = score.map((el, i) => [el, i]).sort((a, b) => b[0] - a[0]);
  const res = new Array(S).fill("0");
  const medals = ["Gold Medal", "Silver Medal", "Bronze Medal"];
  for (let i = 0; i < S; i++) {
    if (i <= 2) {
      res[sortedScore[i][1]] = medals[i];
    } else {
      res[sortedScore[i][1]] = (i + 1).toString();
    }
  }
  return res;
}
