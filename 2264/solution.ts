function largestGoodInteger(num: string): string {
  let res = "";
  for (let i = 0; i < num.length - 2; i++) {
    if (num[i] == num[i + 1] && num[i + 1] == num[i + 2]) {
      if (!res || res[0] < num[i]) {
        res = num.slice(i, i + 3);
      }
    }
  }
  return res;
}
