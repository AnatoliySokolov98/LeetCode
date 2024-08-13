package main

func numUniqueEmails(emails []string) int {
	res := make(map[string]bool)

	for _, email := range emails {
		local := []byte{}
		domain := ""

		for i := 0; i < len(email); i++ {
			char := email[i]

			if char == '+' {
				for i < len(email) && email[i] != '@' {
					i++
				}
				domain = email[i:]
				break
			}

			if char == '@' {
				domain = email[i:]
				break
			}

			if char != '.' {
				local = append(local, char)
			}
		}

		cleanEmail := string(local) + domain
		res[cleanEmail] = true
	}

	return len(res)
}