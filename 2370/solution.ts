function longestIdealString(s: string, k: number): number {
  const dp = new Array(26).fill(0);
  for (let i = 0; i < s.length; i++) {
    const currValue = s.charCodeAt(i) - "a".charCodeAt(0);
    const bot = Math.max(0, currValue - k);
    const top = Math.min(26, currValue + k + 1);
    dp[currValue] = Math.max(...dp.slice(bot, top)) + 1;
  }
  return Math.max(...dp);
}
