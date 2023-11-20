package main

import (
	"Lab_6/algos"
	"fmt"
)

func main() {
	fmt.Println("=======================================")
	T := "32169902660"
	P := "2660"
	fmt.Println("Source string:", T)
	fmt.Println("Target string:", P)
	fmt.Println("RabinKarp:", algos.RabinKarp(T, P))
	fmt.Println("=======================================\n")

	T = "abcbacdabdbabdbabcabdbab"
	P = "abdbab"
	fmt.Println("Source string:", T)
	fmt.Println("Target string:", P)
	fmt.Println("BoyerMoore:", algos.BoyerMoore(T, P))
	fmt.Println("=======================================\n")

	T = "abcbacdabdbabdbabcabdbab"
	P = "abdbab"
	fmt.Println("Source string:", T)
	fmt.Println("Target string:", P)
	fmt.Println("KnuthMorrisPratt:", algos.KnuthMorrisPratt(T, P))
	fmt.Println("=======================================\n")
}
