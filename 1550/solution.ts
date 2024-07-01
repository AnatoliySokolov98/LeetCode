function threeConsecutiveOdds(arr: number[]): boolean {
  let streak = 0;
  for (const a of arr) {
    if (a % 2) {
      streak++;
      if (streak == 3) {
        return true;
      }
    } else {
      streak = 0;
    }
  }
  return false;
}
