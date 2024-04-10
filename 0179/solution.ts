function largestNumber(nums: number[]): string {
  nums.sort((a, b) => {
    const left = String(a);
    const right = String(b);
    return left + right > right + left ? -1 : 1;
  });
  const res = nums.join("");
  let i = 0;
  while (i < res.length && res[i] == "0") i++;
  return i === res.length ? "0" : res.slice(i);
}
