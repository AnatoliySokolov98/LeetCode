function replaceElements(arr: number[]): number[] {
  let num = -1;
  for (let i = arr.length - 1; i >= 0; i--) {
    [arr[i], num] = [num, Math.max(num, arr[i])];
  }
  return arr;
}
