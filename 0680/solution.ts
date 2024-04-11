function validPalindrome(s: string): boolean {
  const check = (left: number, right: number): boolean => {
    while (left < right) {
      if (s[left++] !== s[right--]) {
        return false;
      }
    }
    return true;
  };

  let l = 0;
  let r = s.length - 1;
  while (l < r) {
    if (s[l] !== s[r]) {
      return check(l + 1, r) || check(l, r - 1);
    }
    l++;
    r--;
  }
  return true;
}
