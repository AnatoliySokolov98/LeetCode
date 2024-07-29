function numTeams(rating: number[]): number {
  let res = 0;
  for (let i = 0; i < rating.length; i++) {
    let l = 0;
    let r = 0;
    for (let j = 0; j < i; j++) {
      if (rating[j] < rating[i]) {
        l++;
      }
    }
    for (let j = i + 1; j < rating.length; j++) {
      if (rating[j] > rating[i]) {
        r++;
      }
    }
    res += r * l;
    res += (i - l) * (rating.length - i - 1 - r);
  }
  return res;
}
