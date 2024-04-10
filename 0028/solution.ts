function strStr(haystack: string, needle: string): number {
  return needle === "" ? 0 : haystack.indexOf(needle);
}
