package main

import (
	"Lab_5a/algos"
	"fmt"
)

func main() {
	g := algos.NewUndirectedGraph[int]()
	test1 := [][]int{{1, 2}, {1, 3}, {2, 4}, {3, 4}, {2, 5}, {4, 5}, {3, 6}, {3, 7}}
	for _, edge := range test1 {
		g.AddEdge(edge[0], edge[1])
	}
	fmt.Println(g)
	g.DFS(1)
	g.BFS(1)

	g = algos.NewUndirectedGraph[int]()
	test2 := [][]int{{1, 2, 2}, {1, 3, 1}, {1, 4, 4}, {1, 6, 6}, {2, 5, 3}, {2, 4, 1}, {3, 6, 4}, {3, 4, 2}, {4, 7, 1}, {5, 7, 4}, {6, 7, 7}}
	for _, edge := range test2 {
		g.AddWeightedEdge(edge[0], edge[1], edge[2])
	}
	fmt.Println(g)
	g.Dijkstra(4)

	g1 := algos.NewUndirectedGraph[string]()
	test3Edges := [][]string{{"A", "B"}, {"A", "C"}, {"A", "D"}, {"B", "E"}, {"B", "D"}, {"C", "D"}, {"C", "F"}, {"C", "G"}, {"D", "G"}, {"D", "E"}}
	test3Weights := []int{1, 2, 4, 5, 2, 7, 4, 1, 1, 1}
	for i := 0; i < len(test3Edges); i++ {
		g1.AddWeightedEdge(test3Edges[i][0], test3Edges[i][1], test3Weights[i])
	}
	fmt.Println(g1)
	g1.FloydWarshall()

	g = algos.NewUndirectedGraph[int]()
	test4 := [][]int{{1, 2, 2}, {1, 3, 1}, {1, 4, 3}, {1, 6, 6}, {2, 5, 3}, {2, 4, 1}, {3, 6, 3}, {3, 4, 2}, {4, 7, 1}, {5, 7, 4}, {6, 7, 7}}
	for _, edge := range test4 {
		g.AddWeightedEdge(edge[0], edge[1], edge[2])
	}
	fmt.Println(g)
	g.Prim()
	g.Kruskal()
}
