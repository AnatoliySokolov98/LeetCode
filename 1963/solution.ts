function minSwaps(s: string): number {
  let res = 0;
  let curr = 0;
  for (const char of s) {
    if (char == "[") {
      curr++;
    } else if (char == "]") {
      curr--;
    }
    if (curr < 0) {
      res++;
      curr += 2;
    }
  }
  return res;
}
