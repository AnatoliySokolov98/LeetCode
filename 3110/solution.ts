function scoreOfString(s: string): number {
  let res = 0;
  for (let i = 0; i < s.length - 1; i++) {
    res += Math.abs(s.charCodeAt(i) - s.charCodeAt(i + 1));
  }
  return res;
}
