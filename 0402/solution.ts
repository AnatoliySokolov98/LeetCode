function removeKdigits(num: string, k: number): string {
  const res: Array<string> = [];
  for (let char of num) {
    while (k && res.length && res[res.length - 1] > char) {
      res.pop();
      k--;
    }
    res.push(char);
  }
  let answer = res.join("");
  let i = 0;
  while (i < answer.length && answer[i] == "0") {
    i++;
  }
  answer = answer.slice(i);
  return answer.length - k > 0 ? answer.slice(0, answer.length - k) : "0";
}
