function numberToWords(num: number): string {
  const lessThanTen = [
    "",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
  ];
  const lessThanTwenty = [
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen",
  ];
  const lessThanHundred = [
    "",
    "Ten",
    "Twenty",
    "Thirty",
    "Forty",
    "Fifty",
    "Sixty",
    "Seventy",
    "Eighty",
    "Ninety",
  ];
  const MIL = 1_000_000;
  const BIL = 1_000_000_000;
  let res: string[] = [];

  if (num === 0) {
    return "Zero";
  }

  function makeNumber(num: number): void {
    if (num === 0) {
      return;
    } else if (num < 10) {
      res.push(lessThanTen[num]);
    } else if (num < 20) {
      res.push(lessThanTwenty[num - 10]);
    } else if (num < 100) {
      res.push(lessThanHundred[Math.floor(num / 10)]);
      makeNumber(num % 10);
    } else if (num < 1000) {
      res.push(lessThanTen[Math.floor(num / 100)]);
      res.push("Hundred");
      makeNumber(num % 100);
    } else if (num < MIL) {
      makeNumber(Math.floor(num / 1000));
      res.push("Thousand");
      makeNumber(num % 1000);
    } else if (num < BIL) {
      makeNumber(Math.floor(num / MIL));
      res.push("Million");
      makeNumber(num % MIL);
    } else {
      makeNumber(Math.floor(num / BIL));
      res.push("Billion");
      makeNumber(num % BIL);
    }
  }

  makeNumber(num);
  return res.join(" ");
}
