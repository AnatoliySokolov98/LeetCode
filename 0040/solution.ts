function combinationSum2(candidates: number[], target: number): number[][] {
  candidates.sort((a, b) => a - b);

  const cache: Record<string, number[][]> = {};
  const dp = (i: number, target: number) => {
    if (i === candidates.length) {
      return [];
    }
    const key = `${i},${target}`;
    if (Object.hasOwn(cache, key)) {
      return cache[key];
    }
    if (candidates[i] === target) {
      cache[key] = [[target]];
    } else if (candidates[i] > target) {
      cache[key] = [];
    } else {
      let res = [];
      let out = dp(i + 1, target - candidates[i]);
      if (out.length) {
        for (let item of out) {
          res.push([candidates[i]].concat(item));
        }
      }
      while (i < candidates.length - 1 && candidates[i] === candidates[i + 1]) {
        i++;
      }
      out = dp(i + 1, target);
      if (out.length) {
        for (let item of out) {
          res.push(item);
        }
      }
      cache[key] = res;
    }
    return cache[key];
  };
  return dp(0, target);
}
