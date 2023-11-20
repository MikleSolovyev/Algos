package algos

var (
	d = 256
	q = 31
)

func RabinKarp(T string, P string) []int {
	src := []byte(T)
	target := []byte(P)
	var result []int

	n := len(src)
	m := len(target)

	dPowM := modularPow(d, m-1, q)
	var hSrc, hTarget int

	for i := 0; i < m; i++ {
		hSrc = (d*hSrc)%q + int(src[i])%q
		hTarget = (d*hTarget)%q + int(target[i])%q
	}

	for s := 0; s <= n-m; s++ {
		if hSrc == hTarget {
			if isEqual(target, src[s:s+m]) {
				result = append(result, s)
			}
		}

		if s == n-m {
			break
		}

		hSrc = (d*(hSrc-(dPowM*int(src[s]))%q+q))%q + int(src[s+m])%q
	}

	return result
}

func modularPow(base int, n int, modulus int) int {
	c := 1
	for i := 0; i < n; i++ {
		c = (c * base) % modulus
	}

	return c
}

func isEqual[T comparable](a []T, b []T) bool {
	result := true

	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			result = false
			break
		}
	}

	return result
}
