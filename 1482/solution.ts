function minDays(bloomDay: number[], m: number, k: number): number {
  if (m * k > bloomDay.length) {
    return -1;
  }
  let l = Infinity;
  let r = 0;
  for (const flower of bloomDay) {
    l = Math.min(l, flower);
    r = Math.max(r, flower);
  }
  let res = r;
  while (l <= r) {
    let p = Math.floor((l + r) / 2);
    if (canMakeBouquets(bloomDay, m, k, p)) {
      res = p;
      r = p - 1;
    } else {
      l = p + 1;
    }
  }
  return res;
}
const canMakeBouquets = (
  bloomDay: number[],
  m: number,
  k: number,
  day: number
) => {
  let res = 0;
  let curr = 0;
  for (const flower of bloomDay) {
    if (flower <= day) {
      curr++;
      if (curr == k) {
        res++;
        curr = 0;
        if (res == m) {
          return true;
        }
      }
    } else {
      curr = 0;
    }
  }
  return false;
};
