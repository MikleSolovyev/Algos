package algos

func KnuthMorrisPratt(T string, P string) []int {
	src := []byte(T)
	target := []byte(P)
	var result []int

	m := len(target)
	pi := prefixFunc(target)
	k := 0

	for i := 0; i < len(T); i++ {
		for k > 0 && target[k] != src[i] {
			k = pi[k-1]
		}

		if target[k] == src[i] {
			k++
		}

		if k == m {
			result = append(result, i-m+1)
			k = pi[k-1]
		}
	}

	return result
}
