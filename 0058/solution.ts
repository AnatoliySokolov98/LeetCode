function lengthOfLastWord(s: string): number {
  let i = s.length - 1;
  while (s[i] === " ") {
    i--;
  }
  let j = i;
  while (j >= 0 && s[j] !== " ") {
    j--;
  }
  return i - j;
}
