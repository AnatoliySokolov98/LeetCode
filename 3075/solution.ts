function maximumHappinessSum(happiness: number[], k: number): number {
  happiness.sort((a, b) => b - a);
  let res = 0;
  for (let i = 0; i < k; i++) {
    const currHappiness = happiness[i] - i;
    if (currHappiness <= 0) {
      return res;
    }
    res += currHappiness;
  }
  return res;
}
