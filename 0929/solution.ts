function numUniqueEmails(emails: string[]): number {
  const res = new Set<string>();
  for (let email of emails) {
    const curr: string[] = [];
    for (let i = 0; i < email.length; i++) {
      if (email[i] === "+") {
        let j = i;
        while (email[j] !== "@") {
          j++;
        }
        res.add(curr.join("") + email.slice(j));
        break;
      }
      if (email[i] === ".") continue;
      if (email[i] === "@") {
        res.add(curr.join("") + email.slice(i));
        break;
      }
      curr.push(email[i]);
    }
  }
  return res.size;
}
