function numRescueBoats(people: number[], limit: number): number {
  people.sort((a, b) => a - b);
  let l = 0;
  let r = people.length - 1;
  let res = 0;
  while (l <= r) {
    if (people[l] + people[r] <= limit) {
      l++;
    }
    r--;
    res++;
  }
  return res;
}
