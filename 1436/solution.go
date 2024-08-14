package main

func destCity(paths [][]string) string {
	dests := make(map[string]bool)
	for _, path := range paths {
		dests[path[1]] = true
		dests[path[0]] = true
	}
	for _, path := range paths {
		dests[path[0]] = false
	}

	for key, val := range dests {
		if val {
			return key
		}
	}
	return "None"
}