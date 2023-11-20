package main

import (
	"Lab_5b/algos"
	"fmt"
)

func main() {
	g := algos.NewUndirectedGraph[int]()
	test1 := [][]int{{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 6}, {4, 5}, {5, 6}}
	for _, edge := range test1 {
		g.AddEdge(edge[0], edge[1])
	}
	fmt.Println(g)
	g.LoopMerge(6)

	g = algos.NewUndirectedGraph[int]()
	for _, edge := range test1 {
		g.AddEdge(edge[0], edge[1])
	}
	fmt.Println(g)
	g.Fleury(6)

	g1 := algos.NewDirectedGraph[string]()
	test2 := [][]string{{"A", "C"}, {"A", "B"}, {"C", "D"}, {"C", "F"}, {"B", "D"}, {"D", "G"}, {"E", "F"}, {"F", "G"}}
	for _, edge := range test2 {
		g1.AddEdge(edge[0], edge[1])
	}
	fmt.Println(g1)
	g1.Tarjan()

	g2 := algos.NewDirectedGraph[int]()
	test3 := [][]int{{1, 4}, {4, 1}, {4, 5}, {5, 2}, {2, 1}, {8, 5}, {8, 7}, {3, 2}, {3, 5}, {3, 7}, {6, 5}, {6, 3}, {7, 6}, {7, 3}}
	for _, edge := range test3 {
		g2.AddEdge(edge[0], edge[1])
	}
	fmt.Println(g2)
	g2.Kosaraju()
}
