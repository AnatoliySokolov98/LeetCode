function countSeniors(details: string[]): number {
  return details.reduce(
    (acc, detail) => (parseInt(detail.slice(11, 13)) > 60 ? acc + 1 : acc),
    0
  );
}
