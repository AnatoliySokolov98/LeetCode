function isIsomorphic(s: string, t: string): boolean {
  if (s.length !== t.length) {
    return false;
  }

  const sMap: Map<string, string> = new Map();
  const tMap: Map<string, string> = new Map();
  for (let i = 0; i < s.length; i++) {
    const sChar = s[i];
    const tChar = t[i];
    if (sMap.has(sChar) && sMap.get(sChar) !== tChar) {
      return false;
    } else {
      sMap.set(sChar, tChar);
    }
    if (tMap.has(tChar) && tMap.get(tChar) !== sChar) {
      return false;
    } else {
      tMap.set(tChar, sChar);
    }
  }
  return true;
}
