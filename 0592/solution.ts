function fractionAddition(expression: string): string {
  // Split the expression into fractions
  const fractions: string[] = [];
  let i = 0;
  const n = expression.length;
  while (i < n) {
    let start = i;
    if (expression[i] === "+" || expression[i] === "-") {
      i++;
    }
    while (i < n && expression[i] !== "+" && expression[i] !== "-") {
      i++;
    }
    fractions.push(expression.substring(start, i));
  }

  // Initialize the result as the first fraction
  const firstFraction = fractions[0].split("/");
  let totalNumerator = parseInt(firstFraction[0]);
  let totalDenominator = parseInt(firstFraction[1]);

  // Add fractions one by one
  for (let j = 1; j < fractions.length; j++) {
    const parts = fractions[j].split("/");
    const numerator = parseInt(parts[0]);
    const denominator = parseInt(parts[1]);

    // Calculate the new numerator and denominator
    totalNumerator =
      totalNumerator * denominator + numerator * totalDenominator;
    totalDenominator = totalDenominator * denominator;

    // Simplify the fraction using GCD
    const commonDivisor = gcd(Math.abs(totalNumerator), totalDenominator);
    totalNumerator = Math.floor(totalNumerator / commonDivisor);
    totalDenominator = Math.floor(totalDenominator / commonDivisor);
  }

  // Return the result as a string
  return `${totalNumerator}/${totalDenominator}`;
}

function gcd(a: number, b: number): number {
  if (b === 0) {
    return a;
  }
  return gcd(b, a % b);
}
