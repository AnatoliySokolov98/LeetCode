function destCity(paths: string[][]): string {
  const cities = new Set<string>();

  // Collect outgoing cities
  for (const path of paths) {
    cities.add(path[0]);
  }

  // Find destination city with no outgoing path
  for (const path of paths) {
    const dest = path[1];
    if (!cities.has(dest)) {
      return dest;
    }
  }

  return "";
}
