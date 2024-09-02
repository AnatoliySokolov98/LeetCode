function chalkReplacer(chalk: number[], k: number): number {
  let total = 0;
  for (const student of chalk) {
    total += student;
  }
  k %= total;
  for (let i = 0; i < chalk.length; i++) {
    if (chalk[i] > k) {
      return i;
    }
    k -= chalk[i];
  }
  return -1;
}
