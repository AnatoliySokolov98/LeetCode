function canBeEqual(target: number[], arr: number[]): boolean {
  target.sort((a, b) => a - b);
  arr.sort((a, b) => a - b);
  for (let i = 0; i < arr.length; i++) {
    if (target[i] !== arr[i]) {
      return false;
    }
  }
  return true;
}
