function isAnagram(s: string, t: string): boolean {
  if (s.length !== t.length) {
    return false;
  }

  const letters: Record<string, number> = {};
  for (let i = 0; i < s.length; i++) {
    letters[s[i]] = (letters[s[i]] || 0) + 1;
    letters[t[i]] = (letters[t[i]] || 0) - 1;
  }
  return Math.max(...Object.values(letters)) === 0;
}
