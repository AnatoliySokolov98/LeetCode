function numWaterBottles(
  fullBottles: number,
  emptyToFullRatio: number
): number {
  let emptyBottles = 0;
  let res = 0;
  while (fullBottles > 0) {
    res += fullBottles;
    emptyBottles += fullBottles;
    fullBottles = Math.floor(emptyBottles / emptyToFullRatio);
    emptyBottles = emptyBottles % emptyToFullRatio;
  }
  return res;
}
