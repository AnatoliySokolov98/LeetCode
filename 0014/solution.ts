function longestCommonPrefix(strs: string[]): string {
  let prefix = strs[0].length - 1;
  for (let i = 1; i < strs.length; i++) {
    if (prefix === -1) return "";
    prefix = Math.min(prefix, strs[i].length - 1);
    for (let j = 0; j < strs[i].length; j++) {
      if (j > prefix) {
        break;
      }
      if (strs[i][j] !== strs[0][j]) {
        prefix = j - 1;
        break;
      }
    }
  }
  return strs[0].slice(0, prefix + 1);
}
