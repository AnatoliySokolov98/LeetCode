function maxDistance(position: number[], m: number): number {
  position.sort((a, b) => a - b);
  let l = 1;
  let r = position[position.length - 1] - position[0];
  let res = 1;
  while (l <= r) {
    let p = l + Math.floor((r - l) / 2);
    if (canPlace(position, m, p)) {
      res = p;
      l = p + 1;
    } else {
      r = p - 1;
    }
  }
  return res;
}

const canPlace = (position: Array<number>, m: number, distance: number) => {
  let res = 0;
  let lastLocation = -distance;
  for (const location of position) {
    if (location - lastLocation >= distance) {
      res++;
      lastLocation = location;
    }
  }
  return res >= m;
};
