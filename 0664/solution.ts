function strangePrinter(s: string): number {
  s = removeDuplicates(s);

  const n = s.length;
  const memo: number[][] = Array.from({ length: n }, () => Array(n).fill(0));

  return dp(s, 0, n - 1, memo);
}

function removeDuplicates(s: string): string {
  let result = s[0];
  for (let i = 1; i < s.length; i++) {
    if (s[i] !== s[i - 1]) {
      result += s[i];
    }
  }
  return result;
}

function dp(s: string, i: number, j: number, memo: number[][]): number {
  if (i > j) {
    return 0;
  }
  if (memo[i][j] !== 0) {
    return memo[i][j];
  }

  let res = 1 + dp(s, i + 1, j, memo);

  for (let k = i + 1; k <= j; k++) {
    if (s[i] === s[k]) {
      res = Math.min(res, dp(s, i + 1, k, memo) + dp(s, k + 1, j, memo));
    }
  }

  memo[i][j] = res;
  return res;
}
