function maxDistance(arrays: number[][]): number {
  let res = 0;
  let prevBig = arrays[0][arrays[0].length - 1];
  let prevSmall = arrays[0][0];

  for (let i = 1; i < arrays.length; i++) {
    let currBig = arrays[i][arrays[i].length - 1];
    let currSmall = arrays[i][0];
    res = Math.max(res, currBig - prevSmall);
    res = Math.max(res, prevBig - currSmall);
    prevBig = Math.max(prevBig, currBig);
    prevSmall = Math.min(prevSmall, currSmall);
  }
  return res;
}
