function compareVersion(version1: string, version2: string): number {
  const V1 = version1.length;
  const V2 = version2.length;
  let i = 0;
  let j = 0;
  while (i < V1 || j < V2) {
    let v1 = 0;
    while (i < V1 && version1[i] != ".") {
      v1 = v1 * 10 + parseInt(version1[i++]);
    }
    i++;

    let v2 = 0;
    while (j < V2 && version2[j] != ".") {
      v2 = v2 * 10 + parseInt(version2[j++]);
    }
    j++;
    console.log(v1, v2);
    if (v1 < v2) {
      return -1;
    }
    if (v1 > v2) {
      return 1;
    }
  }
  return 0;
}
