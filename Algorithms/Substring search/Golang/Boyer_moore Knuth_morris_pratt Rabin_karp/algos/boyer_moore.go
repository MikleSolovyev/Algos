package algos

var alphabet = []byte{'a', 'b', 'c', 'd'}

func BoyerMoore(T string, P string) []int {
	src := []byte(T)
	target := []byte(P)
	var result []int

	suffixTable := getSuffixTable(target)
	stopTable := getStopTable(target)

	for i := 0; i < len(src)-len(target)+1; {
		j := len(target) - 1
		for j >= 0 && target[j] == src[i+j] {
			j--
		}

		deltaStop := 1
		if j == -1 {
			result = append(result, i)
		} else {
			deltaStop = j - stopTable[src[i+j]]
		}

		deltaSuffix := suffixTable[j+1]

		i += max(deltaStop, deltaSuffix)
	}

	return result
}

func getSuffixTable(target []byte) []int {
	m := len(target)
	pi := prefixFunc(target)
	piReversed := prefixFunc(reverseSlice(target))

	resultTable := make([]int, m+1)
	for i := 0; i < m+1; i++ {
		resultTable[i] = m - pi[m-1]
	}

	for i := 0; i < m; i++ {
		index := m - piReversed[i]
		shift := i - piReversed[i] + 1

		if resultTable[index] > shift {
			resultTable[index] = shift
		}
	}

	return resultTable
}

func getStopTable(target []byte) map[byte]int {
	resultTable := make(map[byte]int, len(alphabet))
	for _, char := range alphabet {
		resultTable[char] = -1
	}

	for i := 0; i < len(target)-1; i++ {
		resultTable[target[i]] = i
	}

	return resultTable
}

func max(a int, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}

func prefixFunc(S []byte) []int {
	pi := make([]int, len(S))
	k := 0

	for i := 1; i < len(S); i++ {
		for k > 0 && S[k] != S[i] {
			k = pi[k-1]
		}

		if S[k] == S[i] {
			k++
		}

		pi[i] = k
	}

	return pi
}

func reverseSlice[T any](a []T) []T {
	result := make([]T, len(a))

	for i := 0; i < len(a); i++ {
		result[len(a)-1-i] = a[i]
	}

	return result
}
