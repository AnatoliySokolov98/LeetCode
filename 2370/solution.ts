function longestIdealString(s: string, k: number): number {
  const dp = new Array(26).fill(0);
  for (let i = 0; i < s.length; i++) {
    const currValue = s.charCodeAt(i) - "a".charCodeAt(0);
    let currTotal = 1;
    for (let j = 0; j < 26; j++) {
      if (Math.abs(j - currValue) <= k) {
        currTotal = Math.max(currTotal, dp[j] + 1);
      }
    }
    dp[currValue] = currTotal;
  }
  return Math.max(...dp);
}
