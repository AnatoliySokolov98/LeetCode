class Solution:
    def numUniqueEmails(self, emails: list[str]) -> int:
        uniques = set()
        for email in emails:
            curr = []
            for i, v in enumerate(email):
                if v == ".":
                    continue
                if v == "+":
                    index = i
                    while email[index] != "@":
                        index += 1
                    uniques.add("".join(curr) + "@" + email[index + 1 :])
                    break
                if v == "@":
                    uniques.add("".join(curr) + "@" + email[i + 1 :])
                    break
                curr.append(v)
        return len(uniques)
