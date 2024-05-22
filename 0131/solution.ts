function partition(s: string): string[][] {
  const res: Array<Array<string>> = [];
  const curr: Array<string> = [];
  const isPal = (l: number, r: number) => {
    while (l < r) {
      if (s[l++] !== s[r--]) {
        return false;
      }
    }
    return true;
  };
  const backtrack = (i: number) => {
    if (i == s.length) {
      res.push([...curr]);
      return;
    }
    for (let j = i; j < s.length; j++) {
      if (isPal(i, j)) {
        curr.push(s.slice(i, j + 1));
        backtrack(j + 1);
        curr.pop();
      }
    }
  };
  backtrack(0);
  return res;
}
