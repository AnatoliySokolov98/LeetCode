function countStudents(students: number[], sandwiches: number[]): number {
  const counts = [0, 0];
  for (const student of students) {
    counts[1] += student;
  }
  counts[0] = students.length - counts[1];
  for (let i = 0; i < sandwiches.length; i++) {
    if (counts[sandwiches[i]] == 0) {
      return sandwiches.length - i;
    }
    counts[sandwiches[i]]--;
  }
  return 0;
}
